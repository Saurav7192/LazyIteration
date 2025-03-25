# LazyIteration

A demonstration of on-demand data fetching behavior similar to AWS SDK's `SdkIterable<Page<T>>` using Java and MySQL.

## Problem Statement

When working with DynamoDB using the AWS SDK for Java v2, I encountered unexpected behavior with `SdkIterable<Page<T>>`:

- Set a `Limit` of 10 items in my query
- Expected only 10 items in a single page
- Observed DynamoDB returning all matching items across multiple pages
- Raised questions about true on-demand fetching behavior

## Solution Approach

### Understanding `SdkIterable`

AWS SDK's `SdkIterable<Page<T>>` implements lazy loading with:
- Immediate fetch of first page
- Subsequent pages fetched only when requested
- Pagination controlled by `LastEvaluatedKey`

### Key Concepts

| Concept | Description |
|---------|-------------|
| **On-Demand Fetching** | Pages fetched only when needed, reducing memory usage |
| **Pagination** | Results split into pages (≤1MB or `Limit` items) |
| **Limit Parameter** | Controls max items evaluated per query |

## Implementation

This project simulates the behavior using:
- Java 18
- MySQL local database
- This is nowhere near close to aws actual implementation, it is just for our understanding.

### Class Structure

```java
title Class Diagram
classDiagram
    class Student {
    }
    
    class Page {
    }
    
    class MySqlResponse {
    }
    
    class MySqlConnector {
    }
    
    class GetQuery {
    }
    
    class CustomIterable {
    }
    
    MySqlResponse --|> CustomIterable
    MySqlResponse --> GetQuery
    GetQuery --> MySqlConnector
    GetQuery --> Student
```

### Core Components

#### `Student.java`
Data class representing student records

#### `Page.java`
Wrapper for paginated results

#### `MySqlResponse.java`
Implements lazy loading logic

#### `CustomIterable.java`
Interface defining iteration behavior

## Key Observations

### First Page
- Fetched immediately during initialization
- Contains up to limit items

### Subsequent Pages
- Only fetched when `next()` is called
- Query uses updated offset value

### Termination
- Stops when `hasNext()` returns `false`
- Determined by empty result set

## Conclusion

This implementation demonstrates:
- True on-demand fetching behavior
- Memory-efficient pagination
- Clean separation of concerns

The pattern mirrors AWS SDK's `SdkIterable` while being more transparent about the fetching mechanism.
