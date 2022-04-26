# Test Plan - Project “Minions”

### Table of Contents
**[1. Introduction](#1-introduction)**

**[2. Scope](#2-scope)**

> **[2.1 Functions To Be Tested](#21-functions-to-be-tested)**

> **[2.2 Functions Not To Be Tested](#22-functions-not-to-be-tested)**

**[3. Quality Objectives](#3-quality-objectives)**

> **[3.1 Primary Objectives](#31-primary-objectives)**

> **[3.2 Secondary Objectives](#32-secondary-objectives)**

**[4. Test Approach](#4-test-approach)**

**[5. Roles And Responsibilities](#5-roles-and-responsibilities)**

**[6. Entry And Exit Criteria](#6-entry-and-exit-criteria)**

> **[6.1 Entry Criteria](#61-entry-criteria)**

> **[6.1 Exit Criteria](#62-exit-criteria)**

**[7. Test Strategy](#7-test-strategy)**

> **[7.1 QA Role In Test Process](#71-qa-role-in-test-process)**

> **[7.2 Bug Life Cycle](#72-bug-life-cycle)**

> **[7.3 Testing Types](#73-testing-types)**

> **[7.4 Bug Severity And Priority Definition](#74-bug-severity-and-priority-definition)**

**[8. Resource And Environment Needs](#8-resource-and-environment-needs)**

> **[8.1 Testing Tools](#81-testing-tools)**

> **[8.2 Test Environment](#82-test-envirionment)**

**[9. Test Schedule](#9-test-schedule)**

### Document Revision History

| Date | Version | Description | Author | Reviewer | Approver |
|------|---------|-------------|--------|----------|----------|
|22.02|0.1|Test plan was created for Sprint 1|Minions|Srilekha|Prof. Bill|
|06.03|0.1|Test plan was created for Sprint 2|Minions|Srilekha|Prof. Bill|
|12.04|0.1|Test plan was created for Sprint 3|Minions|Srilekha|Prof. Bill|
|18.04|0.1|Test plan was created for Sprint 4|Minions|Srilekha|Prof. Bill|

### 1. INTRODUCTION

Customers expect a flawless website that has undergone a thorough cycle of manual testing. Given the site's uniqueness, maintaining the same level of quality and consistency is critical.
The Test Plan was established to help team members communicate more effectively. This document outlines the procedures and methodologies that will be used to test the "Registration and Login of Minions Portal" unit, integration, and system. The objectives, test responsibilities, entry and exit criteria, scope, main schedule milestones, entrance and exit criteria, and approach are all included. This document specifies the test deliverables as well as what is considered in and out of scope.

### 2. SCOPE

The document mainly targets the GUI testing and validating data in report output as per Requirements Specifications provided by Client.
> #### 2.1  Functions to be tested
●   Searching
●   System Tests
●   Test Sign up
●   Test Sign in
●	Test set preferences
●	Test show merged articles
●	Test show category articles
●	Test searching
●	Test advanced searching

> #### 2.2 Functions not to be tested
●   None other than mentioned above in section 2.1

### 3. QUALITY OBJECTIVES

> #### 3.1   Primary Objectives
A fundamental goal of testing is to ensure that the system meets all criteria, including quality requirements (both functional and non-functional) and fit metrics for each quality requirement, as well as to satisfy use case scenarios and maintain product quality. The user should find that the project has met or exceeded all of their expectations as outlined in the requirements at the end of the project development cycle.
Any changes, additions, or deletions to the requirements document, Functional Specification, or Design Specification shall be documented and tested to the highest quality possible given the project's remaining timeframe and the test team's capabilities.

> #### 3.2	Secondary Objectives
Secondary testing goals include identifying and exposing all issues and hazards, communicating all known issues to the project team, and ensuring that all concerns are addressed appropriately before release. As a goal, this necessitates thorough and methodical testing of the program to guarantee that all aspects of the system are examined and, as a result, all issues (bugs) discovered are addressed effectively.

### 4. TEST APPROACH

As a result, the approach adopted is analytical, in accordance with a requirements-based strategy, in which an examination of the requirements specification serves as the foundation for planning.
calculating and planning tests During exploratory testing, test cases will be produced. Test Strategy determines all test kinds. We are majorly focusing on the TDD approach.
Using testers' abilities and intuition, as well as their expertise with similar applications or technologies, the team must also apply experience-based testing and error guessing.
The project is being carried out in an agile manner, with weekly iterations. The needs established for that iteration will be presented to the team and tested at the end of each week.

### 5. ROLES AND RESPONSIBILITIES

| Role | Staff Member | Responsibilities |
|------|--------------|------------------|
| Project Manager | Prof. Bill | 1.Acts as a primary contact for development and QA team.|
| | | 2.Responsible for Project schedule and the overall success of the project.|
| QA | S. Srilekha | 1. Participation in the project plan creation/update process. |
|||2.Planning and organization of the test process for the release. |
|||3.Report progress on work assignments to the PM. |
|||4.Writing and executing Test cases. |
|||5.Reviewing Test cases. |
|||6.Coordinate with QA Lead for any issues or problems encountered during test preparation/execution/defect handling. |
| DEV/UI | Jaswin / Vikram | 1.	Understand requirements. |
|||2.	Front-End development. |
|||3.	Back-End code development. |
|||4.	DB Connection. |
|||5.	Bug Review meeting. |
|||6.	Preparation of Test Data. |
|||7.	Coordinate with QA Lead for any issues or problems encountered during test preparation/execution/defect handling. |

### 6. ENTRY AND EXIT CRITERIA

> #### 6.1	Entry Criteria
●	All test hardware platforms must have been installed, configured, and tested successfully.
●	All relevant documentation, design, and requirements information should be available so that testers may operate the system and assess its right behavior.
●	All of the standard software tools, including the testing tools, must have been installed and tested successfully.
●	There is sufficient test data available.
●	The test environment, including the lab, hardware, software, and system administration support, should all be in place.
●	The requirements have been thoroughly understood by the QA resources.
●	QA personnel are well-versed in functionality.
●	Test scenarios and test cases were reviewed.

> #### 6.2	Exit Criteria
●	A specific level of coverage of requirements has been attained.
●	There are no high-priority or serious bugs left unresolved.
●	Only minimal residual concerns remain after all high-risk regions have been      thoroughly examined.
●	The schedule has been achieved

### 7. TEST STRATEGY

> #### 7.1	QA role in test process
- **Understanding Requirements:**
    - Requirement specifications will be sent by client.
    - Understanding of requirements will be done by QA
- **Preparing Test Cases:**
    - On the basis of the exploratory testing, QA will prepare test cases. This will cover all requirements scenarios.
    - Examining the test cases and the matrix
    -	QA Lead will conduct peer review for test cases and test matrix.
    -	Reviewers shall submit any comments or suggestions on test cases and test coverage to the respective Author of Test Case and Test Matrix.
    -	Author will rework any suggestions or improvements and send them for approval.
    -	The reviewer will look through the reworked improvements and approve them.
- **Creating Test Data:**
    -    Test data will be created by respective QA on client's developments/test site based on scenarios and Test cases.
- **Executing Test Cases:**
    -	Test cases will be executed by respective QA on the client's development/test site based on designed scenarios, test cases and Test data.
    -	Test result (Actual Result, Pass/Fail) will updated in test case document Defect Logging and Reporting.
    -	QA will be logging the defect/bugs, found during execution of test cases. After this, QA will inform the respective developer about the defect/bugs.
- **Retesting and Regression Testing:**
    -	Retesting for fixed bugs will be done by respective QA once it is resolved by the respective developer and bug/defect status will be updated accordingly. In certain cases, regression testing will be done if required.
- **Deployment/Delivery:**
    -	After all reported issues/defects have been resolved and no new bugs have been discovered, the report will be deployed to the client's test site by PM.
    -	If necessary, QA will do one round of testing on the client's test site. The report will be emailed to the appropriate lead and Report group, along with a sample output.
    -   The filled hard copy of the delivery slip will be submitted to the appropriate developer by QA.
    -	Lead will send the report delivery email to the client after he receives the hard copy of the delivery slip filled out by QA and development.

> #### 7.2	Bug life cycle:
All the issues found while testing will be logged into Word documents.
Bug life cycle for this project is as follows:
![Bug Life Cycle](/buglifecycle.png)

> #### 7.3	Testing types:

- **Black box testing:**
    -   It is sometimes called behavioral testing or Partition testing. This kind of testing focuses on the functional requirements of the software. It enables one to derive sets of input conditions that will fully exercise all functional requirements for a program.
- **GUI Testing:**
    -   GUI testing will include testing the UI part of the report. It covers users Report format, look and feel, error messages, spelling mistakes, GUI guideline violations.
- **Integration Testing:**
    -   Integration testing is a systematic technique for constructing the program structure while conducting tests to uncover errors associated with interacting. In Report, integration testing includes the testing Report from respective location(s).
- **Functional Testing:**
    -   Functional testing is carried out in order to find out unexpected behavior of the report. The characteristics of functional testing are to provide correctness, reliability, testability and accuracy of the report output/data.
- **System Testing:**
    -   System testing of software is testing conducted on a complete, integrated system to evaluate the system's compliance with its specified requirements.
- **Performance Testing:**
    -	Check the optimal time the page is loaded
    -   Check the operation of the system under load 
- **User acceptance testing:**
    -   The purpose behind user acceptance testing is to confirm that the system is developed according to the specified user requirements and is ready for operational use. Acceptance testing is carried out at two levels - Alpha and Beta Testing. User acceptance testing (UAT) will be done at the Client.
- **Alpha testing:**
    -   The alpha test is conducted at the developer's site by client.

> #### 7.4 Bug Severity and Priority Definition
Bug Severity and Priority fields are both very important for categorizing bugs and prioritizing if and when the bugs will be fixed.   The bug Severity and Priority levels will be defined as outlined in the following tables below. Testing will assign a severity level to all bugs. The Test Lead will be responsible to see that a correct severity level is assigned to each bug.
The QA Lead, Development Lead and Project Manager will participate in bug review meetings to assign the priority of all currently active bugs. This meeting will be known as “Bug Triage Meetings”. The QA Lead is responsible for setting up these meetings on a routine basis to address the current set of new and existing but unresolved bugs.

> **Severity List**
The tester entering a bug into GForge is also responsible for entering the bug Severity.

| Severity ID | Severity | Severity Description |
|-------------|----------|----------------------|
| 1 | Critical | The module/product crashes or the bug causes non- recoverable conditions. System crashes, GP Faults, or database or file corruption, or potential data loss, program hangs requiring reboot are all examples of a Sev. 1 bug. |
| 2 | High | Major system components unusable due to failure or incorrect functionality. Sev. 2 bugs cause serious problems such as a lack of functionality, or insufficient or unclear error messages that can have a major impact on the user, prevent other areas of the app from being tested, etc. Sev. 2 bugs can have a work around, but the work around is inconvenient or difficult. |
| 3 | Medium | Incorrect functionality of component or process.	There is a simple work around for the bug if it is Sev. 3. |
| 4 | Minor | Documentation errors or signed off severity 3 bugs. |

> **Priority List**

| Priority | Priority Level | Priority Description |
|----------|----------------|----------------------|
| 1 | Must Fix | This bug must be fixed immediately; the product cannot ship with this bug. |
| 2 | Should Fix | These are important problems that should be fixed as soon as possible. It would be an embarrassment to the company if this bug shipped. |

### 8. RESOURCE AND ENVIRONMENT NEEDS

> #### 8.1	Testing Tools

| Process | Tool |
|---------|------|
| Test case creation | Microsoft Excel |
| Test case tracking | Microsoft Excel |
| Test case execution | Manual |
| Test case management | Microsoft Excel |
| Defect management | Microsoft Word |
| Test reporting | Microsoft Word |

> #### 8.2 Test Envirionment
	Support level 1 (browsers):
    	Windows 10: Edge, Chrome (latest), Firefox (latest), Safari (latest)
    	
### 9. TEST SCHEDULE

| Task Name | Start | Finish | Effort | Comments |
|-----------|-------|--------|--------|----------|
| Test Planning | 04/18 | 04/18 | | Support! |
| Review Requirements documents | 04/18 | 04/18 | |
| Create test basis | 04/22	| 04/22 | | 
| Staff	and	train new test resources | 04/23 | 04/23 | |
| First	deploy	to	QA	test environment | 04/24 | 04/24 | |
| Functional testing – Iteration 1 | 04/25 | 04/25| |
| Regression testing | 04/25 | 04/25 | |
| UAT |04/25 | 04/25 | |
| Resolution of  final defects and final build testing | 04/25 | 04/25 | |
| Release to Production |04/26 | 04/26 | |

### APPROVALS

| | Project Manager | QA Lead |
|---|---------------|---------|
| Name | Prof. Bill | S. Srilekha |
| Signature | | |

### TERMS/ACRONYMS
The below terms are used as examples, please add/remove any terms relevant to the document.

| TERM/ACRONYM | DEFINITION |
|--------------|------------|
| API | Application Program Interface |
| GUI | Graphical user interface |
| PM | Project manager |
| UAT | User acceptance testing |
| CM | Configuration Management |
| QA | Quality Assurance |
