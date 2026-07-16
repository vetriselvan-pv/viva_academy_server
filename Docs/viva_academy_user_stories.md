# 📋 Viva Academy - Comprehensive Application User Stories

Welcome to the official Product Backlog and Requirement Document for **Viva Academy**. This document outlines detailed user stories, acceptance criteria, and system architecture parameters required to build a multi-branch, multi-class coaching management application.

---

## 👥 1. User Personas & Definitions

| Persona | Role Description | Key Focus Areas |
| :--- | :--- | :--- |
| **Super Admin** | Executive-level user with global access across all physical and digital centers. | Global configuration, cross-branch analytics, system audits, financial control. |
| **Branch Admin** | Operations head assigned to one or more specific physical branches. | Branch-specific scheduling, staff allocation, batch adjustments, fee approvals. |
| **Enquiry Person** | Front-desk sales executives, tele-callers, and academic counselors. | Lead generation, customer relationship management (CRM), follow-ups, admissions conversion. |
| **Teacher / Faculty** | Academic educators, mentors, and class instructors. | Attendance marking, marks entry, study material uploads, student engagement. |
| **Student / Parent** | Primary consumer of educational services (and their financial guardians). | Timetables, academic performance tracking, online fee payments, communication. |

---

## 🏗️ 2. Architectural & Multi-Tenant Foundations (SME Blueprint)

Before implementing the user stories, the system architecture must enforce strict **Data Isolation and Multi-Branch scoping**:
1. **The Branch Scope:** Every database transaction (apart from Super Admin global configurations) must be mapped to a specific `branch_id`. 
2. **Role-Based Access Control (RBAC):** Users must be bound to single or multiple branches. An Enquiry Person at *Branch A* must never see leads from *Branch B* unless explicitly granted access.
3. **Multi-Class Flexibility:** The structure must support a hierarchical taxonomy:  
   `Branch` ➔ `Course Type (e.g., K-12, Competitive Exams)` ➔ `Class/Grade (e.g., Grade 10)` ➔ `Subject (e.g., Physics)` ➔ `Batch (e.g., Morning Alpha Batch)`.

---

## 🔧 3. User Stories & Acceptance Criteria

### Module 1: Super Admin & Branch Admin (Operations & Configuration)

#### 🏷️ US-101: Multi-Branch Infrastructure Setup
> **As a** Super Admin  
> **I want to** provision, manage, and monitor multiple branches of Viva Academy  
> **So that** I can track operational metrics and enforce geographical data segregation across all franchises and centers.

*   **Acceptance Criteria:**
    *   [ ] The system must provide a global dashboard containing a creation form for new branches containing fields: `Branch Name`, `Unique Branch Code`, `Geo-Location/Address`, `Primary Contact Number`, `Email`, and `Tax/GST Registration Number`.
    *   [ ] Super Admins must be able to toggle a branch's status between `Active`, `Suspended`, or `Archived`.
    *   [ ] **Security Constraint:** When any user authenticates, their session must token-bind them to their assigned `branch_id`. Any API call without a valid scope must throw a `403 Forbidden` error.

#### 🏷️ US-102: Class, Course, and Batch Lifecycle Management
> **As a** Branch Admin  
> **I want to** configure academic frameworks, courses, subjects, and specific student batches  
> **So that** scheduling and student enrollment can function without operational clashes.

*   **Acceptance Criteria:**
    *   [ ] Admin must be able to create a master `Course` entity and associate it with target academic terms or classes (e.g., "IIT-JEE Crash Course 2026").
    *   [ ] Admin must be able to subdivide courses into distinct physical or virtual `Batches` with predefined maximum capacities (e.g., "Max 40 Students").
    *   [ ] The system must feature an automated conflict-checker algorithm that throws an instant validation warning if a physical classroom or an individual teacher is booked for overlapping timeslots within the same branch.

#### 🏷️ US-103: Automated Granular RBAC Provisioning
> **As a** Super Admin  
> **I want to** provision system access accounts for Teachers, Branch Admins, and Enquiry Persons  
> **So that** operational boundaries are strictly respected based on organizational duties.

*   **Acceptance Criteria:**
    *   [ ] Super Admins can issue an invitation to a staff member's email, or manually create credentials with a forced "reset-password-on-first-login" constraint.
    *   [ ] The interface must present an access matrix checklist where custom permissions (e.g., `View Revenue Reports`, `Edit Student Profile`) can be enabled or disabled for individual roles.
    *   [ ] System logs must record an immutable audit trail (`User`, `Timestamp`, `Action`, `IP Address`) whenever user access privileges are altered.

---

### Module 2: Enquiry Person (Sales & Lead CRM)

#### 🏷️ US-201: Omni-channel Lead Intake & Deduplication
> **As an** Enquiry Person  
> **I want to** log incoming prospects from walk-ins, phone calls, or digital landing pages  
> **So that** every potential registration opportunity is institutionalized immediately.

*   **Acceptance Criteria:**
    *   [ ] The intake screen must require mandatory baseline inputs: `Student First/Last Name`, `Parent/Guardian Name`, `Primary Mobile Number`, `Email Address`, `Current Grade`, and `Target Course/Batch`.
    *   [ ] **Deduplication Engine:** Upon entering a phone number or email, the system must trigger an asynchronous background check. If a match exists in the database, it must surface a warning toast: *"Lead already exists assigned to [Staff Name] at [Branch Name]"*, preventing duplicate entry creation.
    *   [ ] The application must automatically stamp the logged-in user's active `branch_id` onto the newly created lead record.

#### 🏷️ US-202: Intelligent Dynamic Follow-up Pipelines
> **As an** Enquiry Person  
> **I want to** catalog interaction outcomes, assign current intent scores, and queue subsequent action items  
> **So that** high-priority prospects are systematic converted.

*   **Acceptance Criteria:**
    *   [ ] Each lead card must allow updates to status stages via a structured progression flow: `New` ➔ `Contacted` ➔ `Demo Attended` ➔ `Follow-Up Scheduled` ➔ `Converted` / `Lost`.
    *   [ ] When setting a status to `Follow-Up Scheduled`, the user *must* pick a future date and time timestamp. This action programmatically populates the Enquiry Person's daily dashboard alert queue.
    *   [ ] The home interface for the Enquiry Person must feature a high-priority widget displaying all overdue and current-day follow-ups, complete with direct click-to-dial or click-to-WhatsApp API templates.

#### 🏷️ US-203: One-Click Structural Admission Transition
> **As an** Enquiry Person  
> **I want to** convert a qualified hot lead into an officially registered student account without repetitive manual entry  
> **So that** onboarding latency is eliminated.

*   **Acceptance Criteria:**
    *   [ ] A `Convert to Admission` control must present itself once a lead is flagged for enrollment.
    *   [ ] Activating conversion must carry over all collected biographical data into a full student dossier form and prompt for missing mandatory details: `Assigned Batch`, `Roll Number Allocation`, and `Fee Structure Plan Selection`.
    *   [ ] Upon execution, the lead state shifts to `Converted`, a new record is added to the `Students` collection, and an auto-generated SMS/Email invitation containing login credentials and installation links is dispatched to the parent.

---

### Module 3: Teacher / Faculty (Academic Delivery)

#### 🏷️ US-301: Digital Attendance Roster Management
> **As a** Teacher  
> **I want to** quickly mark and submit daily attendance metrics for my scheduled batches  
> **So that** student tracking remains precise and parents are alerted of absences instantly.

*   **Acceptance Criteria:**
    *   [ ] The teacher profile must show an automated checklist of classes scheduled for the current calendar date.
    *   [ ] Selecting a class must load an alphabetized roster of students assigned to that batch, defaulting all statuses to `Present`. Teachers toggle students to `Absent` or `Late` with single-tap controls.
    *   [ ] Upon submitting the roster, the background service must immediately queue a transactional notification (Push notification, SMS, or WhatsApp webhook) to the parents of all absent students.

#### 🏷️ US-302: Continuous Assessment Gradebook Processing
> **As a** Teacher  
> **I want to** record test results, assign batch performance marks, and append descriptive notes  
> **So that** performance trajectories can be monitored across terms.

*   **Acceptance Criteria:**
    *   [ ] Teachers must be able to define a `New Test Evaluation` record by picking the target batch, establishing `Total Marks`, setting a `Passing Threshold`, and indicating the `Date of Test`.
    *   [ ] The gradebook grid must permit rapid column-based entry of raw scores for each student, dynamically calculating percentages on the fly.
    *   [ ] The platform must validate inputs against the defined bounds (e.g., entering `55` in a test out of `50` must throw an error block and block submissions).

---

### Module 4: Student & Parent (Academic & Financial Consumer Portal)

#### 🏷️ US-401: Unified Interactive Daily Timeline Dashboard
> **As a** Student / Parent  
> **I want to** access an optimized daily homepage containing current class timetables, upcoming examinations, and active announcements  
> **So that** daily learning management is synchronized across home and campus.

*   **Acceptance Criteria:**
    *   [ ] The initial landing screen must display a chronological timeline view of today's schedule, including `Start/End Time`, `Subject Label`, `Assigned Room/Lab Code`, and `Faculty Name`.
    *   [ ] The app must display an explicit ticker bar for high-priority global branch announcements (e.g., "Branch Closed for Holiday on Friday").
    *   [ ] If a virtual class link is configured (e.g., Zoom/Meet URL for hybrid batches), a persistent `Join Class` button must become active exactly 10 minutes prior to the designated start time.

#### 🏷️ US-402: Ledger Visibility & Digital Fee Payments
> **As a** Student / Parent  
> **I want to** examine my complete account financial ledger, check outstanding balance cycles, and process instantaneous digital invoices  
> **So that** account standing remains clear and penalties are minimized.

*   **Acceptance Criteria:**
    *   [ ] The finance tab must display an overview breakdown box containing: `Total Course Fees`, `Total Paid Amount`, `Current Outstanding Balances`, and `Next Payment Due Date`.
    *   [ ] The portal must support a downloadable PDF itemized ledger showing historic installments, payment modes (Card, Net Banking, UPI), and auto-generated receipt documents.
    *   [ ] Selecting `Pay Installment` must connect securely to a production payment gateway API handler, processing webhooks instantly to move invoices from `Pending` to `Paid` status post-authorization.

#### 🏷️ US-403: Academic Growth & Attendance Analytics
> **As a** Student / Parent  
> **I want to** view visualized metrics mapping my performance benchmarks and class attendance rates  
> **So that** actionable feedback can be used to improve academic outcomes.

*   **Acceptance Criteria:**
    *   [ ] The analytics UI must present a color-coded calendar canvas tracking monthly attendance: green highlights indicate present, red blocks indicate unexcused absences, and yellow signifies late check-ins. An ongoing summary indicator must calculate overall compliance (e.g., "Current Attendance: 88%").
    *   [ ] Examination metrics must be mapped out using performance trends. Each test entry must display the individual score earned alongside the calculated *Class Average Score* and *Highest Score Secured in Batch* to provide a clear performance context.

---

## 💾 4. SME Conceptual Entity-Relationship Data Model (ERD Breakdown)

To guide your backend implementation and ensure cross-branch scoping functions efficiently, use this relational entity architecture layout:

```text
+-------------------+             +-------------------+             +-------------------+
|      BRANCH       |             |      COURSE       |             |       BATCH       |
+-------------------+             +-------------------+             +-------------------+
| branch_id   (PK)  |<-----------+| course_id   (PK)  |<-----------+| batch_id    (PK)  |
| name              |             | branch_id   (FK)  |             | course_id   (FK)  |
| code   (Unique)   |             | name              |             | name              |
| address / phone   |             | syllabus_details  |             | max_capacity      |
+-------------------+             +-------------------+             | start/end_time    |
          |                                 |                       +-------------------+
          |                                 |                                 |
          |                                 +---------------+                 |
          |                                                 |                 |
          v                                                 v                 v
+-------------------+             +-------------------+             +-------------------+
|       USER        |             |       LEAD        |             |    ENROLLMENT     |
+-------------------+             +-------------------+             +-------------------+
| user_id     (PK)  |             | lead_id     (PK)  |             | enrollment_id(PK) |
| branch_id   (FK)  |<-----------+| branch_id   (FK)  |             | student_id   (FK) |
| name / email      |             | student_name      |             | batch_id     (FK) |
| password_hash     |             | phone   (Unique)  |             | enrollment_date   |
| role (Admin/Staff)|             | status (New/Follow)             | status (Active/In)|
+-------------------+             +-------------------+             +-------------------+
```

### Key Technical Engineering Recommendations:
1. **Indexes:** Apply composite indexes on `(branch_id, status)` and `(branch_id, created_at)` across your tables to ensure rapid load times for branch-specific queries.
2. **Soft Deletes:** Implement soft-delete patterns (`deleted_at` timestamps) instead of hard SQL `DELETE` queries across crucial tables like `Students`, `Leads`, and `Batches` to protect historical academic records and audit trails.
3. **Audit Trail:** Create a central database interceptor middleware layer that tracks changes to models to trace administrative updates or manual balance overrides easily.
