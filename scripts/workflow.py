import argparse
import leetcode
from utils import JSO
from utils import scriptsDir, joinPath, realPath, createDir, isExist, outFile, copyFile, readFile

# Generate main config file from definition config before starting
configPath = joinPath(scriptsDir, 'config.json')
if not isExist(configPath):
    copyFile(joinPath(scriptsDir, 'config.def'), configPath)

# Parse Arguments
parser = argparse.ArgumentParser(description='Automatically Fetch and generate LeetCode problem and solution files '
                                             'and Update Project\'s README.md List')
parser.add_argument('-s', '--submissions', help='Download your latest submitted solution instead of snippet(only with '
                                                'account session)', action='store_true')
parser.add_argument('-q', '--query', help='LeetCode problem search query')
parser.add_argument('-n', '--number', help='LeetCode problem number')

args = parser.parse_args()

if args.number is None and args.query is None:
    parser.print_help()
    exit(0)

# Some important variables
config = JSO(configPath, 1)
readmeName = "README.md"
problemsPath = realPath(joinPath(scriptsDir, '../problems'))
problemEndPoint = 'https://leetcode.com/problems/'
queryMode = args.number is None

print('[=>] LeetCode Workflow Starting')

# Checking User Status
isPremiumUser = False
isSignedInUser = False
if config.get('useAccount'):
    # Update session token
    leetcode.setSessionToken(config.get('sessionToken'))

    # Get User Status
    userStatus = leetcode.getUserStatus()
    isPremiumUser = bool(userStatus['isPremium'])

    # Handle when user not signed in
    if not userStatus['isSignedIn']:
        print('[!] You are Not SignedIn with this token, Please Update your Token')
        answer = input(f'[!] Do you want to continue without session (yes/no)? ')
        if any(answer.lower() == f for f in ['no', 'n']):
            print("[!] Generation Stopped")
            exit(0)
    else:
        isSignedInUser = True
        print(f'[=>] Welcome {userStatus["username"]}, LeetCode {"Premium" if isPremiumUser else "Free"} User')

print('[=>] Searching Your Problem on LeetCode..')

problem = leetcode.searchProblem(args.query if queryMode else args.number)
if not problem or (not queryMode and problem['questionId'] != str(args.number)):
    print("[X] Problem Not Found!")
    exit(0)

print(f'[=>] Found Your Problem "{problem["title"]}"')
print('[=>] Fetching Problem Details')

details = leetcode.getProblemDetails(problem['titleSlug'])
if not details:
    print("[X] Problem Details Not Found!")
    exit(0)

print('[=>] Found Problem Details')

# Display Problem Info
print(f'[*] Id: {details["questionId"]}')
print(f'[*] Title: {details["title"]}')
print(f'[*] Type: {"Premium" if details["isPaidOnly"] else "Free"}')
print(f'[*] Difficulty: {details["difficulty"]}')
print(f'[*] Likes: {details["likes"]}')
print(f'[*] Dislikes: {details["dislikes"]}')
print(f'[*] Topics: {", ".join([x["name"] for x in details["topicTags"]])}')

answer = input('Do you want to continue (yes/no)? ')
if any(answer.lower() == f for f in ['no', 'n']):
    print("[!] Generation Stopped")
    exit(0)

# Premium problem check
if details["isPaidOnly"] and not isPremiumUser:
    print("[X] Premium Problems Are Only For Premium Accounts")
    exit(0)

# Directory for Problem
dirName = config.get('problemDirName')
dirName = dirName.replace('[questionId]', details['questionId'])
dirName = dirName.replace('[titleSlug]', details['titleSlug'])
dirName = dirName.replace('[title]', details['title'])
dirName = dirName.replace('[difficulty]', details['difficulty'].lower())
dirName = dirName.replace('[isPaid]', "premium" if details['isPaidOnly'] else "free")

problemDir = joinPath(problemsPath, dirName)
if createDir(problemDir):
    print(f'[=>] Generating Directory For "{problem["title"]}"')

# README.md for Problem
mdPath = joinPath(problemDir, readmeName)
if not isExist(mdPath):
    content = f"# [{details['title']}]({problemEndPoint}{details['titleSlug']}/)\n"
    content += f"### **🔒 LeetCode Premium**" if details['isPaidOnly'] else ""
    content += f"### **Difficulty:**  `{details['difficulty']}`\n"
    content += f"### **Topics:** {' '.join(['`' + x['name'] + '`' for x in details['topicTags']])}\n\n"
    content += details['content']
    outFile(mdPath, content)
    print(f'[=>] Generating {readmeName}')

# Solution files for Problem
solName = config.get('solutionFileName')
solName = solName.replace('[questionId]', details['questionId'])
solName = solName.replace('[titleSlug]', details['titleSlug'])
solName = solName.replace('[title]', details['title'])
solName = solName.replace('[difficulty]', details['difficulty'].lower())
solName = solName.replace('[isPaid]', "premium" if details['isPaidOnly'] else "free")

# Submission List
subsList = []
if isSignedInUser and args.submissions:
    print(f'[=>] Fetching Your Submission Entries')
    subsList = leetcode.getSubmissionsList(details['titleSlug'])

# Generate files for given languages with snippets
allSols = []
solPath = joinPath(problemDir, solName)
for lang in config.get('solutionLangs'):
    code = ""
    path = solPath + lang["ext"]

    # Try to find from Submission List
    for sub in subsList:
        if sub['lang'] == lang['lang']:
            code = leetcode.getSubmittedCode(sub['url'])
            break

    # Snippet as fallback
    if len(code) < 2:
        # Code snippet
        for snip in details['codeSnippets']:
            if snip['langSlug'] == lang['lang']:
                code = snip['code']
                break

    # Write to file
    if not isExist(path):
        outFile(path, code)
        print(f'[=>] Generating {lang["name"]} Solution File')

    allSols.append({"name": lang["name"], "path": f"./problems/{dirName}/{solName}{lang['ext']}"})

# Update Project's README.md
print(f'[=>] Updating Project\'s {readmeName} Problem List')

prjReadMePath = realPath(joinPath(scriptsDir, f'../{readmeName}'))
readMe = readFile(prjReadMePath)

# Split file part before and after entry
isNewEntry, preEntry, postEntry = "\n", "", ""

# To skip duplicate entry
if readMe.find("|[" + details['title']) < 0:
    print('[=>] Creating New Problem Entry At The Top')

    # List finding trick, Offset to length of seperator
    listStartLoc = readMe.find('--:|\n') + 4

    # Get both the entry
    preEntry = readMe[:listStartLoc]
    postEntry = readMe[listStartLoc:]
else:
    # Update exiting entry
    print('[=>] Updating Existing Problem Entry')
    isNewEntry = ""
    # Get both the entry
    entryStart = readMe.find(f"|{details['questionId']}|")
    preEntry = readMe[:entryStart]

    # Middle ground trick to find correct offset
    middle = readMe[entryStart:]
    entryEnd = middle.find("|\n") + 1
    postEntry = middle[entryEnd:]

# Construct file with new entry
readMe = preEntry + isNewEntry
readMe += f"|{details['questionId']}"
readMe += f"|[{details['title']}]({problemEndPoint}{details['titleSlug']}/)"
readMe += "🔒|" if details['isPaidOnly'] else "|"
readMe += ", ".join([f'[{x["name"]}]({x["path"]})' for x in allSols])
readMe += f"|{details['difficulty']}|"
readMe += postEntry

outFile(prjReadMePath, readMe)

print("[=>] LeetCode Workflow Complete")
