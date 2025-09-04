# LETS PLAY

A Java backend project using Hexagonal Architecture, integrated with MongoDB and containerized using Docker. It follows clean architecture principles with clear separation of concerns between domain logic, application logic, and infrastructure.

---

## 📁 1.3 Project Structure (Hexagonal Architecture)

```
src/main/java/com/letsplay/
    ├── LetsPlayApplication.java
    ├── domain/                    # Core business logic (no dependencies)
    │   ├── model/
    │   ├── port/
    │   │   ├── in/               # Input ports (use cases)
    │   │   └── out/              # Output ports (interfaces)
    │   └── service/              # Domain services (business logic)
    ├── infrastructure/           # External concerns
    │   ├── config/
    │   ├── persistence/          # Database adapters
    │   │   └── entity/
    │   └── security/
    └── application/              # Application layer
        ├── controller/           # REST controllers
        ├── dto/                  # Data Transfer Objects
        │   ├── request/
        │   └── response/
        └── exception/            # Global exception handling

Other Files:
├── .env-example        # Example environment file
├── compose.yaml        # Docker Compose configuration
└── pom.xml             # Maven configuration

````

---

## Getting Started

### 1. Clone the Repo

```bash
git clone https://github.com/hmaach/lets-play.git
cd lets-play
````

---

### 2. Set Up the Environment

Copy the example `.env` file and fill in your MongoDB credentials:

```bash
cp .env-example .env
```

Then update `.env` with your desired MongoDB credentials:

```env
MONGO_INITDB_ROOT_USERNAME=username
MONGO_INITDB_ROOT_PASSWORD=password
```

---

### 3. Start MongoDB with Docker Compose

Make sure Docker (rootless-compatible) and Docker Compose v2 are installed.

Start the container in detached mode:

```bash
docker compose up -d
```

This will:

* Start MongoDB on port `27017`
* Use environment variables from `.env`
* Create a Docker volume to persist data

---

### 4. Connect to MongoDB

#### From Host Machine (if `mongosh` or `mongo` CLI is installed)

```bash
mongosh "mongodb://localhost:27017"
```

---

### 5. Stop MongoDB

To stop and remove the container:

```bash
docker compose down
```

---

## ✅ Requirements

* [x] Java 17+
* [x] Maven
* [x] Angular (for frontend integration)
* [x] MongoDB (running in Docker)
* [x] `mongosh` for database testing
* [x] Docker (Rootless compatible)
* [x] Docker Compose v2 
