# Mini SOM Simulator

A mini enterprise workflow engine built using Spring Boot to simulate SOM (Service Order Management) concepts.

This project is created for learning enterprise system design, workflow processing, REST API development, and Spring Boot architecture.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Architecture

Client -> Controller -> Service -> Repository -> Database

## Features

### Work Order

- Create Work Order
- Generate default activities
- Work Order status management

### Activity Workflow

- Parent-Child relationship
- Activity dependency (Predecessor)
- Automatic release of next activity
- Workflow completion

### Business Rules

- New Work Order starts with `SUBMITTED`
- First activity starts with `RDY`
- Dependent activities start with `NRD`
- Callback updates activity status
- When predecessor completes, next activity becomes `RDY`
- When all activities are completed, Work Order becomes `COM`

## Current Workflow

COM Create Order
↓
SOM Create Work Order
↓
Status = SUBMITTED
↓
Workflow Engine generate Activities
↓
Activity 1 = RDY
Activity 2 = NRD
Activity 3 = NRD
↓
State Transition
↓
Database

## Learning Objectives

## This project demonstrates

- Spring Boot Layered Architecture
- REST API Design
- DTO Pattern
- Entity Relationships
- One-To-Many / Many-To-One Mapping
- Business Rules
- Workflow Engine Concepts
- Validation
- Enterprise Application Design

## Upcoming Features

- Global Exception Handling
- Poller Simulation
- Scheduler
- Retry Mechanism
- Async Processing
- JMS Simulation
- Event Driven Workflow
