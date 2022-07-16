# LeetCode Workflow
a python3 script to automate the sync of your LeetCode Problems to your repo. Only dependency is 'requests', which you can install easily with
`pip3 install requests`.

### Inspired By [haoel/leetcode](https://github.com/haoel/leetcode) and [QasimWani/LeetHub](https://github.com/QasimWani/LeetHub)

## Features
- Quick way to add new LeetCode Question to your problems list
- Automatically Fetch Question and Code Snippets From LeetCode
- Access Premium Questions(LeetCode Premium Only) and Your submissions using Session Token

## How to use
```
$ python3 scripts/workflow.py -h
usage: workflow.py [-h] [-s] [-q QUERY] [-n NUMBER]

Automatically Fetch and generate LeetCode problem and solution files and Update Project's README.md List

optional arguments:
  -h, --help            show this help message and exit
  -s, --submissions     Download your latest submitted solution instead of snippet(only with account session)
  -q QUERY, --query QUERY
                        LeetCode problem search query
  -n NUMBER, --number NUMBER
                        LeetCode problem number
```

## Example
```
$ python3 scripts/workflow.py -s -n 2
[=>] LeetCode Workflow Starting
[=>] Welcome kexecv, LeetCode Free User
[=>] Searching Your Problem on LeetCode..
[=>] Found Your Problem "Add Two Numbers"
[=>] Fetching Problem Details
[=>] Found Problem Details
[*] Id: 2
[*] Title: Add Two Numbers
[*] Type: Free
[*] Difficulty: Medium
[*] Likes: 19727
[*] Dislikes: 3955
[*] Topics: Linked List, Math, Recursion
Do you want to continue (yes/no)? 
[=>] Generating Directory For "Add Two Numbers"
[=>] Generating README.md
[=>] Fetching Your Submission Entries
[=>] Generating Java Solution File
[=>] Updating Project's README.md Problem List
[=>] Creating New Problem Entry At The Top
[=>] LeetCode Workflow Complete
```

## Configs
Upon first run, Script will generate a default `config.json` file to adjust few settings
```config.json
{
    "useAccount": false,
    "sessionToken": "",
    "problemDirName": "[questionId]-[titleSlug]",
    "solutionLangs": [
        {
            "name" : "Java",
            "lang" : "java",
            "ext": ".java"
        }
    ],
    "solutionFileName": "solution"
}
```

- Account Mode: \
When you want to use your account to fetch submission, make sure to enable it and add your leetcode session token,
You can get session token after login from cookie `LEETCODE_SESSION` on leetcode.com
```
{
    "useAccount": true,
    "sessionToken": "eyJ*****",
    ...
```
- Customise Problem Directory and Solution File Name: \
Examples of few options for customisation
```
    [questionId]: 1
    [title]: Two Sum
    [titleSlug]: two-sum
    [difficulty]: easy
    [isPaid]: free
```
- Customise Solution's Programming Language: \
Examples of few popular languages for customisation
```
{
    ...
    "solutionLangs": [
        { "name" : "C", "lang" : "c", "ext": ".c" },
        { "name" : "C++", "lang" : "cpp", "ext": ".cpp" },
        { "name" : "C#", "lang" : "csharp", "ext": ".cs" },
        { "name" : "Python", "lang" : "python", "ext": ".py" },
        { "name" : "Python3", "lang" : "python3", "ext": ".py" },
        { "name" : "Java", "lang" : "java", "ext": ".java" },
        { "name" : "JavaScript", "lang" : "javaScript", "ext": ".js" },
        { "name" : "Ruby", "lang" : "ruby", "ext": ".rb" },
        { "name" : "Go", "lang" : "go", "ext": ".go" },
        { "name" : "Kotlin", "lang" : "kotlin", "ext": ".kt" },
        { "name" : "Rust", "lang" : "rust", "ext": ".rs" },
        { "name" : "PHP", "lang" : "php", "ext": ".php" },
        ...
    ],
    ...
```

## Anything to say?
Feel free to open an issue for bug or suggestions!

## Technology Communication
> Email: patel.kuldip91@gmail.com