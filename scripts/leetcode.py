import requests

# URL to LeetCode.com
originUrl = "https://leetcode.com"

# URL to LeetCode's GraphQL interface
endPoint = "https://leetcode.com/graphql"

# Request object with Session maintained
session = requests.Session()

# Cookies for User Session
cookies = {}


# Add/Update Session token to Cookie Object
def setSessionToken(token):
    cookies['LEETCODE_SESSION'] = token


# Lookup the problem from LeetCode Server to find Problem Data
def searchProblem(query):
    gqlquery = '''
        query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput){
            problemsetQuestionList: questionList(
                categorySlug: $categorySlug
                limit: $limit
                skip: $skip
                filters: $filters
            ) {
                total: totalNum
                questions: data {
                    questionId
                    title
                    titleSlug
                }
            }
        }
    '''

    variables = {
        "categorySlug": "",
        "skip": 0,
        "limit": 1,
        "filters": {
            "searchKeywords": str(query)
        }
    }

    r = session.post(endPoint, json={"query": gqlquery, "variables": variables}, cookies=cookies)
    if r.status_code == 200:
        result = r.json()
        if 'errors' not in result and result['data']:
            result = result['data']
            if result['problemsetQuestionList']:
                result = result['problemsetQuestionList']
                if result['total'] > 0:
                    return result['questions'][0]
    else:
        print(f"Problem Search Query failed to run with a {r.status_code}.")
        exit(0)

    return None


# Fetch problem details using titleslug from LeetCode Server
def getProblemDetails(title_slug):
    gqlquery = '''
        query questionData($titleSlug: String!) {
            question(titleSlug: $titleSlug) {
                questionId
                title
                titleSlug
                content
                isPaidOnly
                difficulty
                likes
                dislikes
                topicTags {
                    name
                    slug
                }
                codeSnippets {
                    lang
                    langSlug
                    code
                }
            }
        }
    '''

    variables = {
        "titleSlug": str(title_slug)
    }

    r = session.post(endPoint, json={"query": gqlquery, "variables": variables}, cookies=cookies)
    if r.status_code == 200:
        result = r.json()
        if 'errors' not in result and result['data']:
            result = result['data']
            if result['question']:
                return result['question']
    else:
        print(f"Problem Details Query failed to run with a {r.status_code}.")
        exit(0)

    return None


# Fetch User Status with Session from LeetCode Server
def getUserStatus():
    gqlquery = '''
        query globalData {
            userStatus {
                isSignedIn
                isPremium
                username
                realName
            }
        }
    '''

    variables = {}

    r = session.post(endPoint, json={"query": gqlquery, "variables": variables}, cookies=cookies)
    if r.status_code == 200:
        result = r.json()
        if 'errors' not in result and result['data']:
            result = result['data']
            if result['userStatus']:
                return result['userStatus']
    else:
        print(f"User Status Query failed to run with a {r.status_code}.")
        exit(0)

    return None


# Fetch User's Submissions with Session from LeetCode Server
def getSubmissionsList(title_slug):
    gqlquery = '''
        query Submissions($offset: Int!, $limit: Int!, $lastKey: String, $questionSlug: String!) {
            submissionList(offset: $offset, limit: $limit, lastKey: $lastKey, questionSlug: $questionSlug) {
                submissions {
                    statusDisplay
                    lang
                    url
                }
            }
        }
    '''

    variables = {
        "offset": 0,
        "limit": 20,
        "lastKey": None,
        "questionSlug": str(title_slug)
    }

    r = session.post(endPoint, json={"query": gqlquery, "variables": variables}, cookies=cookies)
    if r.status_code == 200:
        result = r.json()
        if 'errors' not in result and result['data']:
            result = result['data']
            if result['submissionList']:
                result = result['submissionList']
                if result['submissions']:
                    # Only Accepted Solutions are needed
                    return [x for x in result['submissions'] if x['statusDisplay'] == "Accepted"]
    else:
        print(f"Submissions List Query failed to run with a {r.status_code}.")
        exit(0)

    return None


# Fetch User's Submitted Code with Session from LeetCode Server
def getSubmittedCode(sub_url):
    r = session.get(originUrl + sub_url, cookies=cookies)
    if r.status_code == 200:
        endingWords = "editCodeUrl: '"
        startingWords = "submissionCode: '"

        # Search through HTML
        submissionCode = r.text[r.text.find(startingWords):r.text.find(endingWords)].strip() \
            .replace(startingWords, '') \
            .replace("',", '')

        # Unescape Unicode Characters
        submissionCode = submissionCode.encode().decode('unicode-escape')

        return submissionCode
    else:
        print(f"Submitted code fetch failed to run with a {r.status_code}.")
        exit(0)

    return None
