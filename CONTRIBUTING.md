# How to contribute
We would love to have your help. Before you start working however, please read
and follow this short guide.

# Development
Clone the repo with git -

# Reporting Issues
Provide as much information as possible. Mention the version of AO Classes, and explain (as detailed as you can) how the 
problem can be reproduced.

# Code contributions
Found a bug and know how to fix it? Great! Please read on.

## Contributor License Agreement
While AO Classes project is released under the
[GNU Affero General Public License v3.0](./LICENSE.md), the only copyright
holder and principal creator is Jagadish Prasad Pattanaik.

## Creating Pull Requests
- Make sure your code passes the linter rules beforehand. The linter is executed
  automatically when committing code.
- Perform **one** logical change per pull request.
- Maintain a clean list of commits, squash them if necessary.
- Rebase your topic branch on top of the master branch before creating the pull
 request.

## Coding style

### Comments

* Comments documenting the source code are required.

* Comments should be formatted as proper English sentences. Such formatting pays
  attention to, for example, capitalization and punctuation.

### Duplication

* Don't copy-paste source code. Reuse it.

### Formatting

* Line length is limited to 120 characters.

* Sort by alphabetical order in order to make the addition of new entities as
  easy as looking a word up in a dictionary. Otherwise, one risks duplicate
  entries (with conflicting values in the cases of key-value pairs)

### Indentation

* Align `switch` and `case`/`default`. Don't indent the `case`/`default` more
  than its `switch`.

### Naming

* An abstraction should have one name within the project and across multiple
  projects.

* The names of global constants (including ES6 module-global constants) should
  be written in uppercase with underscores to separate words. For example,
  `BACKGROUND_COLOR`.

* The underscore character at the beginning of a name signals that the
  respective variable, function, property is non-public i.e. private, protected,
  or internal. In contrast, the lack of an underscore at the beginning of a name
  signals public API.
