# Viva Academy API Usage Guide

Welcome to the Viva Academy API Documentation! This guide is designed to help frontend developers, integration partners, and other API consumers understand how to seamlessly interact with our microservices ecosystem.

## 1. System Architecture & The API Gateway

Our backend is built on a microservices architecture. Instead of calling individual services directly, all client requests must be routed through our **API Gateway**.

- **Base URL (Gateway)**: `http://localhost:8000`
- **Routing Strategy**: The gateway dynamically routes requests to the appropriate service based on the URL path.
  - `/api/v1/students/**` $\rightarrow$ Routes to the Students Service
  - `/api/v1/admin/**` $\rightarrow$ Routes to the Admin Service
  - `/api/v1/auth/**` $\rightarrow$ Routes to the Auth Service

## 2. Standardized Response Format

To ensure a consistent developer experience, every API endpoint returns a standardized JSON structure wrapped in an `ApiResponse` object, regardless of whether the request succeeded or failed.

### Success Response
When a request is successful (HTTP 200/201), the API will return:

```json
{
  "status": "SUCCESS",
  "message": "Student document created successfully",
  "data": {
    "documentId": 1,
    "studentId": "STU123",
    "documentType": "PASSPORT",
    "createdAt": "2026-07-22T10:00:00Z"
  },
  "timestamp": "2026-07-22T10:00:00Z"
}
```

### Error Response
If a request fails (e.g., Resource Not Found, Validation Error), the API will return a descriptive error message and the `data` field will be `null`.

```json
{
  "status": "ERROR",
  "message": "Enquiry not found with ID: 99",
  "data": null,
  "timestamp": "2026-07-22T10:05:00Z"
}
```

## 3. Endpoints Overview

Below are examples of how to consume the recently implemented Student-related APIs through the Gateway.

### Enquiries Management
Manage pre-admission student enquiries.

- **Create Enquiry**
  - **Method**: `POST`
  - **Endpoint**: `/api/v1/students/enquiries`
  - **Payload**:
    ```json
    {
      "branchId": 1,
      "leadSource": "WEBSITE",
      "studentName": "Jane Doe",
      "mobile": "+1234567890",
      "email": "jane@example.com",
      "status": "ENQUIRED",
      "nextFollowUp": "2026-07-25T10:00:00"
    }
    ```

- **Get All Enquiries**
  - **Method**: `GET`
  - **Endpoint**: `/api/v1/students/enquiries`

### Student Documents
Upload and manage documents tied to specific students.

- **Add Document**
  - **Method**: `POST`
  - **Endpoint**: `/api/v1/students/documents`
  - **Payload**:
    ```json
    {
      "studentId": "STU123",
      "documentType": "ID_CARD",
      "file": "base64_encoded_string_or_url"
    }
    ```

- **Get Documents for Student**
  - **Method**: `GET`
  - **Endpoint**: `/api/v1/students/documents/{studentId}`

### Fee Plans & Installments
Manage financial plans and track installment payments.

- **Create Fee Plan**
  - **Method**: `POST`
  - **Endpoint**: `/api/v1/students/fee-plans`
  - **Payload**:
    ```json
    {
      "planId": "PLAN-001",
      "studentId": "STU123",
      "totalFee": 5000.00,
      "discount": 500.00,
      "netFee": 4500.00
    }
    ```

- **Record Fee Installment**
  - **Method**: `POST`
  - **Endpoint**: `/api/v1/students/fee-installments`
  - **Payload**:
    ```json
    {
      "installmentId": "INST-001",
      "planId": "PLAN-001",
      "dueDate": "2026-08-01T00:00:00",
      "amount": 1500.00,
      "status": "PENDING"
    }
    ```

## 4. Best Practices for Integration

> [!TIP]
> Always check the `status` field in the JSON response body (`"SUCCESS"` or `"ERROR"`) in addition to checking HTTP status codes.

> [!WARNING]
> Do **NOT** hardcode direct microservice URLs (e.g., `localhost:8080` for students) in your frontend code. Always route through the Gateway (`localhost:8000`) to avoid cross-origin issues and bypassing security layers.

> [!IMPORTANT]
> Ensure all Date-Time strings sent in request bodies follow standard ISO-8601 formatting (e.g., `YYYY-MM-DDTHH:mm:ss`).
