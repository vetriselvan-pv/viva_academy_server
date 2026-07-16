# Viva Academy Management System (VAMS)

## Project Overview

Viva Academy is a multi-branch coaching institute offering multiple courses and classes. The application will serve four major stakeholders:

1. Students
2. Faculty/Trainers
3. Enquiry Counselors
4. Administrators/Management

The system should support:

- Multi-branch operations
- Multiple courses and batches
- Student lifecycle management
- Enquiry to Admission conversion
- Attendance management
- Fee management
- Exams and Results
- Communication and Notifications
- Reports and Analytics

---

# User Roles

| Role | Description |
|--------|-------------|
| Super Admin | Controls all branches and system settings |
| Branch Admin | Manages a specific branch |
| Enquiry Executive | Handles leads and admissions |
| Faculty | Conducts classes and manages attendance |
| Student | Learner enrolled in courses |
| Parent (Optional) | Views student progress and fees |

---

# Epic 1: Authentication & Authorization

## User Story 1.1: Secure Login

**As a user**
I want to log into the system
So that I can access my role-specific dashboard.

### Acceptance Criteria

- Login using mobile/email and password
- OTP login option
- Forgot password functionality
- Account lock after multiple failed attempts
- Session timeout support

---

## User Story 1.2: Role-Based Access

**As an admin**
I want users to access only authorized features
So that sensitive data remains protected.

### Acceptance Criteria

- Permissions configurable by role
- Menu visibility based on permissions
- Audit log for access activities

---

# Epic 2: Branch Management

## User Story 2.1: Create Branch

**As a Super Admin**
I want to create multiple branches
So that all academy locations can be managed centrally.

### Acceptance Criteria

- Add branch details
- Branch code generation
- Branch contact information
- Branch status (Active/Inactive)

---

## User Story 2.2: Branch Dashboard

**As a Branch Admin**
I want to view branch statistics
So that I can monitor branch performance.

### Acceptance Criteria

- Total students
- Active batches
- Pending fees
- New enquiries
- Faculty count

---

# Epic 3: Course Management

## User Story 3.1: Create Course

**As an Admin**
I want to create courses
So that students can enroll in different programs.

### Acceptance Criteria

- Course name
- Course code
- Duration
- Fee structure
- Syllabus upload
- Branch mapping

---

## User Story 3.2: Manage Course Modules

**As an Admin**
I want to define course modules
So that learning content can be organized.

### Acceptance Criteria

- Module creation
- Topic management
- Sequence ordering

---

# Epic 4: Batch Management

## User Story 4.1: Create Batch

**As a Branch Admin**
I want to create batches
So that students can be grouped into classes.

### Acceptance Criteria

- Batch name
- Course assignment
- Faculty assignment
- Start and end dates
- Batch timing
- Maximum capacity

---

## User Story 4.2: Batch Scheduling

**As a Branch Admin**
I want to schedule classes
So that students know their timetable.

### Acceptance Criteria

- Weekly schedule
- Holiday calendar
- Rescheduling support
- Classroom allocation

---

# Epic 5: Enquiry Management

## User Story 5.1: Capture Enquiry

**As an Enquiry Executive**
I want to register enquiries
So that potential students can be tracked.

### Acceptance Criteria

- Name
- Mobile number
- Email
- Interested course
- Source of lead
- Preferred branch

---

## User Story 5.2: Follow-Up Tracking

**As an Enquiry Executive**
I want to record follow-up activities
So that conversion chances improve.

### Acceptance Criteria

- Call log
- WhatsApp notes
- Meeting notes
- Next follow-up date
- Follow-up reminders

---

## User Story 5.3: Enquiry Pipeline

**As an Enquiry Executive**
I want to track enquiry status
So that lead progression is visible.

### Statuses

- New
- Contacted
- Interested
- Demo Scheduled
- Follow-up
- Admission Confirmed
- Lost

---

## User Story 5.4: Lead Conversion

**As an Enquiry Executive**
I want to convert an enquiry into a student
So that admissions can be processed efficiently.

### Acceptance Criteria

- One-click conversion
- Auto-create student profile
- Auto-generate student ID
- Admission fee collection

---

# Epic 6: Student Management

## User Story 6.1: Student Registration

**As an Admin**
I want to register students
So that their academic records can be maintained.

### Acceptance Criteria

- Personal details
- Parent details
- Address
- Photo upload
- Aadhaar/ID upload
- Emergency contact

---

## User Story 6.2: Student Profile

**As a Student**
I want to view my profile
So that I can verify my information.

### Acceptance Criteria

- Course details
- Batch details
- Attendance summary
- Fee status
- Exam performance

---

## User Story 6.3: Student Transfer

**As an Admin**
I want to transfer students between branches
So that operational changes can be managed.

### Acceptance Criteria

- Branch transfer
- Batch transfer
- Transfer history

---

# Epic 7: Attendance Management

## User Story 7.1: Mark Attendance

**As a Faculty**
I want to mark attendance
So that student participation is recorded.

### Acceptance Criteria

- Present
- Absent
- Late
- Excused

---

## User Story 7.2: Student Attendance View

**As a Student**
I want to view my attendance
So that I can track my participation.

### Acceptance Criteria

- Daily attendance
- Monthly attendance
- Attendance percentage

---

## User Story 7.3: Attendance Alerts

**As an Admin**
I want low attendance alerts
So that corrective action can be taken.

### Acceptance Criteria

- Configurable threshold
- SMS/WhatsApp notification

---

# Epic 8: Fee Management

## User Story 8.1: Fee Structure Setup

**As an Admin**
I want to configure fees
So that course pricing is standardized.

### Acceptance Criteria

- Registration fee
- Tuition fee
- Material fee
- Discounts
- Scholarships

---

## User Story 8.2: Fee Collection

**As a Cashier/Admin**
I want to collect fees
So that payments are tracked accurately.

### Acceptance Criteria

- Cash
- UPI
- Card
- Bank Transfer

---

## User Story 8.3: Installment Management

**As an Admin**
I want installment plans
So that students can pay in stages.

### Acceptance Criteria

- Installment schedule
- Due dates
- Late fee calculation

---

## User Story 8.4: Fee Reminder

**As a Student**
I want fee reminders
So that I can avoid missing payments.

### Acceptance Criteria

- SMS reminder
- Email reminder
- WhatsApp reminder

---

# Epic 9: Exam Management

## User Story 9.1: Create Exam

**As a Faculty**
I want to schedule exams
So that student knowledge can be assessed.

### Acceptance Criteria

- Exam name
- Date
- Batch assignment
- Total marks

---

## User Story 9.2: Enter Marks

**As a Faculty**
I want to record marks
So that results can be published.

### Acceptance Criteria

- Subject-wise marks
- Bulk upload support
- Validation checks

---

## User Story 9.3: Student Results

**As a Student**
I want to view my results
So that I can monitor my progress.

### Acceptance Criteria

- Marks
- Rank
- Percentage
- Grade

---

# Epic 10: Study Material Management

## User Story 10.1: Upload Study Materials

**As a Faculty**
I want to upload learning materials
So that students can access resources.

### Acceptance Criteria

- PDF upload
- Video upload
- Notes upload
- Assignment upload

---

## User Story 10.2: Download Materials

**As a Student**
I want to access course materials
So that I can study anytime.

### Acceptance Criteria

- Search materials
- Download files
- Mobile-friendly access

---

# Epic 11: Assignment Management

## User Story 11.1: Create Assignment

**As a Faculty**
I want to assign homework
So that students practice course concepts.

### Acceptance Criteria

- Due date
- File attachment
- Marks allocation

---

## User Story 11.2: Assignment Submission

**As a Student**
I want to submit assignments
So that faculty can review my work.

### Acceptance Criteria

- File upload
- Submission timestamp
- Resubmission option

---

# Epic 12: Communication Management

## User Story 12.1: Broadcast Notification

**As an Admin**
I want to send announcements
So that students receive important updates.

### Acceptance Criteria

- SMS
- Email
- Push Notification
- WhatsApp

---

## User Story 12.2: Batch Notification

**As a Faculty**
I want to notify a specific batch
So that relevant students are informed.

### Acceptance Criteria

- Batch selection
- Scheduled messages

---

# Epic 13: Student Mobile App

## User Story 13.1: Dashboard

**As a Student**
I want a personalized dashboard
So that I can quickly view my information.

### Dashboard Widgets

- Attendance %
- Upcoming classes
- Pending fees
- Exam schedule
- Notifications

---

## User Story 13.2: Timetable

**As a Student**
I want to view my timetable
So that I can attend classes on time.

### Acceptance Criteria

- Daily schedule
- Weekly schedule
- Faculty information

---

# Epic 14: Faculty Portal

## User Story 14.1: Faculty Dashboard

**As a Faculty**
I want to see my assigned batches
So that I can manage classes efficiently.

### Dashboard Widgets

- Today's classes
- Pending attendance
- Upcoming exams
- Assignment reviews

---

# Epic 15: Reports & Analytics

## User Story 15.1: Admission Report

**As a Management User**
I want admission reports
So that growth trends can be analyzed.

### Metrics

- Daily admissions
- Monthly admissions
- Course-wise admissions
- Branch-wise admissions

---

## User Story 15.2: Revenue Report

**As a Management User**
I want revenue reports
So that financial performance can be tracked.

### Metrics

- Collection summary
- Outstanding fees
- Branch-wise revenue
- Course-wise revenue

---

## User Story 15.3: Attendance Analytics

**As a Management User**
I want attendance analytics
So that student engagement can be monitored.

### Metrics

- Student attendance trends
- Batch attendance trends
- Faculty attendance trends

---

# Epic 16: CRM & Marketing

## User Story 16.1: Lead Source Tracking

**As a Marketing Manager**
I want to know lead sources
So that marketing campaigns can be optimized.

### Sources

- Website
- Walk-in
- Referral
- Social Media
- Google Ads
- Facebook Ads

---

## User Story 16.2: Campaign Analysis

**As a Marketing Manager**
I want conversion reports
So that campaign ROI can be measured.

### Metrics

- Leads generated
- Admissions converted
- Cost per admission

---

# Epic 17: Audit & Security

## User Story 17.1: Activity Logs

**As a Super Admin**
I want audit logs
So that all important activities are traceable.

### Track

- Login history
- Fee modifications
- Student updates
- Attendance changes

---

## Epic 18: Super Admin Features

## User Story 18.1: Global Dashboard

**As a Super Admin**
I want a centralized dashboard
So that all branches can be monitored.

### KPIs

- Total branches
- Total students
- Active enquiries
- Revenue
- Collections due
- Attendance health score

---

# Non-Functional Requirements

## Performance

- Response time < 3 seconds
- Support 10,000+ students
- Support concurrent users

## Security

- JWT Authentication
- Role-based authorization
- Data encryption
- Audit logs

## Availability

- 99.9% uptime
- Daily backup
- Disaster recovery

## Mobile Support

- Android App
- iOS App
- Responsive Web Portal

## Integrations

- WhatsApp Business API
- SMS Gateway
- Razorpay/Stripe
- Google Calendar
- Zoom/Google Meet

---

# Future Enhancements

- AI Chatbot
- AI Attendance using Face Recognition
- Online Test Platform
- Learning Management System (LMS)
- Parent Mobile App
- Franchise Management
- Lead Automation Workflow
- Student Performance Prediction


# Viva Academy ERP – Product Requirements Document (PRD)

# Viva Academy ERP

## 1. Product Vision

Build a centralized ERP platform for Viva Academy that manages the complete student lifecycle across multiple branches, from enquiry generation to admission, fee collection, attendance tracking, examination management, and performance analytics.

The system should support:

* Multi-branch operations
* Multi-course management
* Student mobile application
* Faculty portal
* Enquiry CRM
* Administrative ERP
* Financial management
* Reports and analytics

---

# 2. Business Goals

### Primary Goals

* Increase enquiry-to-admission conversion rate
* Reduce manual administrative work
* Improve fee collection efficiency
* Provide real-time visibility across branches
* Improve student engagement

### Success Metrics

| KPI                       | Target |
| ------------------------- | ------ |
| Lead Conversion Rate      | +25%   |
| Fee Collection Efficiency | +30%   |
| Attendance Accuracy       | 95%+   |
| Admin Work Reduction      | 50%    |
| Student App Adoption      | 80%+   |

---

# 3. User Personas

## Student

Needs:

* Class schedule
* Attendance
* Fees
* Study materials
* Exam results

## Faculty

Needs:

* Attendance marking
* Assignment management
* Exam management

## Enquiry Executive

Needs:

* Lead management
* Follow-up tracking
* Admission conversion

## Branch Admin

Needs:

* Student management
* Fee collection
* Batch management

## Super Admin

Needs:

* Multi-branch monitoring
* Reports
* Security controls

---

# 4. Functional Modules

1. Authentication & RBAC
2. Branch Management
3. CRM & Enquiry Management
4. Student Management
5. Course Management
6. Batch Management
7. Attendance Management
8. Fee Management
9. Exam Management
10. Study Material Management
11. Notification Center
12. Reports & Analytics
13. Mobile App
14. Audit & Security

---

# 5. Functional Requirements

## FR-001 User Login

Users shall authenticate using:

* Mobile OTP
* Email & Password
* Google Login (future)

---

## FR-002 Multi Branch

System shall support:

* Unlimited branches
* Branch-specific data
* Centralized reporting

---

## FR-003 Lead Management

Capture:

* Name
* Mobile
* Email
* Course Interested
* Branch Interested
* Source

Track:

* Follow-ups
* Conversion stages

---

## FR-004 Admission Management

Convert lead to student.

Generate:

* Student ID
* Fee plan
* Batch allocation

---

## FR-005 Attendance

Support:

* Daily attendance
* Batch attendance
* Faculty attendance

---

## FR-006 Fee Management

Support:

* Installments
* Discounts
* Scholarships
* Refunds
* Receipts

---

## FR-007 Examination

Support:

* Exam scheduling
* Marks entry
* Result publication

---

## FR-008 Notifications

Channels:

* Push
* SMS
* Email
* WhatsApp

---

# 6. Non Functional Requirements

## Security

* JWT Authentication
* Refresh Tokens
* MFA Support
* Encryption at Rest

## Performance

* API Response < 2 sec
* 500 Concurrent Users Per Branch

## Scalability

* Horizontal scaling
* Stateless APIs

## Reliability

* Daily backup
* Disaster recovery

---

# 7. Release Plan

## Phase 1

* Authentication
* CRM
* Student Management
* Course Management
* Batch Management

## Phase 2

* Attendance
* Fee Management
* Notifications

## Phase 3

* Exams
* Reports
* Mobile App

## Phase 4

* LMS
* AI Features
* Parent App

# Database Design (High-Level)

## Core Tables

### branches

```sql
branch_id PK
branch_code
branch_name
address
city
state
phone
email
status
created_at
```

### users

```sql
user_id PK
branch_id FK
role_id FK
name
email
mobile
password_hash
status
last_login
created_at
```

### roles

```sql
role_id PK
role_name
description
```

### permissions

```sql
permission_id PK
permission_name
module
```

### role_permissions

```sql
role_permission_id PK
role_id FK
permission_id FK
```

---

## CRM Tables

### enquiries

```sql
enquiry_id PK
branch_id FK
lead_source
student_name
mobile
email
course_id FK
status
assigned_to
next_followup
remarks
created_at
```

### enquiry_followups

```sql
followup_id PK
enquiry_id FK
followup_date
followup_type
remarks
next_followup
created_by
```

---

## Academic Tables

### courses

```sql
course_id PK
course_code
course_name
duration
fee_amount
status
```

### batches

```sql
batch_id PK
course_id FK
branch_id FK
faculty_id FK
batch_name
start_date
end_date
capacity
```

### students

```sql
student_id PK
student_code
branch_id FK
course_id FK
batch_id FK
name
dob
gender
mobile
email
admission_date
status
```

### student_documents

```sql
document_id PK
student_id FK
document_type
file_url
```

---

## Attendance

### attendance

```sql
attendance_id PK
student_id FK
batch_id FK
attendance_date
status
remarks
```

---

## Fee Management

### fee_plans

```sql
plan_id PK
student_id FK
total_fee
discount
net_fee
```

### fee_installments

```sql
installment_id PK
plan_id FK
due_date
amount
status
```

### payments

```sql
payment_id PK
student_id FK
amount
payment_method
transaction_ref
payment_date
```

---

## Exam Module

### exams

```sql
exam_id PK
course_id FK
batch_id FK
exam_name
exam_date
total_marks
```

### exam_results

```sql
result_id PK
exam_id FK
student_id FK
marks
grade
rank
```

---

## Notifications

### notifications

```sql
notification_id PK
title
message
type
target_type
created_by
```

### notification_logs

```sql
log_id PK
notification_id FK
user_id FK
status
sent_at
```

---

# Recommended Microservices Architecture

```text
                         API Gateway
                               |
    ---------------------------------------------------
    |         |         |         |         |          |
 Auth     CRM      Student    Fee      Exam      Notification
 Service  Service  Service    Service  Service   Service
    |         |         |         |         |          |
    ---------------------------------------------------
                       Event Bus
                           |
                  Reporting Service
                           |
                    Analytics Service
```

## Services

### 1. Auth Service

Responsibilities:

* Login
* JWT
* RBAC
* User Management

Database:

```text
users
roles
permissions
```

---

### 2. CRM Service

Responsibilities:

* Enquiries
* Followups
* Lead Conversion

Database:

```text
enquiries
followups
```

---

### 3. Student Service

Responsibilities:

* Student Profile
* Batch Allocation
* Attendance

Database:

```text
students
batches
attendance
```

---

### 4. Fee Service

Responsibilities:

* Fee Plans
* Payments
* Refunds

Database:

```text
fee_plans
payments
```

---

### 5. Exam Service

Responsibilities:

* Exams
* Marks
* Results

Database:

```text
exams
exam_results
```

---

### 6. Notification Service

Responsibilities:

* SMS
* Email
* Push
* WhatsApp

---

### 7. Reporting Service

Responsibilities:

* BI Reports
* Dashboards
* KPI Aggregation

---

# REST API Specification (v1)

## Authentication

### Login

```http
POST /api/v1/auth/login
```

Request

```json
{
  "mobile": "9876543210",
  "password": "******"
}
```

Response

```json
{
  "accessToken": "",
  "refreshToken": "",
  "user": {}
}
```

---

## Enquiry

### Create Enquiry

```http
POST /api/v1/enquiries
```

### List Enquiries

```http
GET /api/v1/enquiries
```

### Add Followup

```http
POST /api/v1/enquiries/{id}/followups
```

### Convert To Student

```http
POST /api/v1/enquiries/{id}/convert
```

---

## Students

### Create Student

```http
POST /api/v1/students
```

### Get Student

```http
GET /api/v1/students/{id}
```

### Update Student

```http
PUT /api/v1/students/{id}
```

---

## Attendance

### Mark Attendance

```http
POST /api/v1/attendance
```

### Get Attendance

```http
GET /api/v1/students/{id}/attendance
```

---

## Fees

### Create Fee Plan

```http
POST /api/v1/fee-plans
```

### Collect Payment

```http
POST /api/v1/payments
```

### Payment History

```http
GET /api/v1/students/{id}/payments
```

---

## Exams

### Create Exam

```http
POST /api/v1/exams
```

### Submit Marks

```http
POST /api/v1/exams/{id}/results
```

### View Results

```http
GET /api/v1/students/{id}/results
```

# UI/UX Wireframes (Screen Structure)

## Admin Dashboard

```text
 -------------------------------------------------
| Viva Academy ERP                               |
 -------------------------------------------------
| Branch | Students | Fees | Attendance | CRM    |
 -------------------------------------------------
| Total Students      | 4,250                    |
| New Admissions      | 123                      |
| Pending Fees        | ₹12,50,000              |
| Today's Attendance  | 92%                      |
 -------------------------------------------------
| Admission Trend Graph                          |
 -------------------------------------------------
| Revenue Graph                                  |
 -------------------------------------------------
```

## CRM Dashboard

```text
 -------------------------------------------------
| New Leads         120                          |
| Followups Today    35                          |
| Converted          15                          |
 -------------------------------------------------
| Lead Pipeline                                 |
| New -> Contacted -> Demo -> Converted         |
 -------------------------------------------------
```

## Student Mobile App

```text
 --------------------------------
| Student Dashboard             |
 --------------------------------
| Attendance      92%           |
| Pending Fee     ₹5,000        |
| Next Class      5 PM          |
| Result          88%           |
 --------------------------------
| Timetable                    |
| Study Material               |
| Assignments                  |
| Payments                     |
| Notifications                |
 --------------------------------
```

## Faculty Dashboard

```text
 --------------------------------
| Today's Classes              |
 --------------------------------
| Batch A - 10 AM              |
| Batch B - 2 PM               |
 --------------------------------
| Mark Attendance              |
| Upload Material              |
| Create Exam                  |
 --------------------------------
```

### Recommended Technology Stack

| Layer          | Technology           |
| -------------- | -------------------- |
| Frontend Web   | Next.js + TypeScript |
| Mobile App     | Flutter              |
| Backend        | NestJS               |
| Database       | PostgreSQL           |
| Cache          | Redis                |
| Queue          | RabbitMQ             |
| Storage        | AWS S3 / MinIO       |
| Authentication | Keycloak / JWT       |
| API Gateway    | Kong / Nginx         |
| Monitoring     | Prometheus + Grafana |
| CI/CD          | GitHub Actions       |
| Hosting        | AWS / Azure / GCP    |

For a production-grade Viva Academy ERP, I would recommend a **modular monolith (NestJS + PostgreSQL)** for Phase 1 and Phase 2, then gradually split into microservices once the system reaches ~10,000+ students and multiple branches. This reduces complexity and speeds up development significantly.
