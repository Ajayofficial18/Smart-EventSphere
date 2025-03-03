# Contributing to EventSphere

Thank you for considering contributing to **EventSphere**! 🚀 We welcome all contributions, whether it's fixing bugs, improving documentation, or adding new features.

## 📌 Getting Started

1. **Fork & Clone**
    - If you're not a collaborator, fork the repository and then clone it:
      ```sh
      git clone https://github.com/your-username/EventSphere.git
      cd EventSphere
      ```
    - If you're a collaborator, simply clone the repo:
      ```sh
      git clone https://github.com/EventSphere/EventSphere.git
      cd EventSphere
      ```

2. **Create a Branch**
    - Always create a new branch for your changes:
      ```sh
      git checkout -b feature-branch-name
      ```
    - Use meaningful branch names, such as:
      ```
      feature-add-swagger
      fix-authentication-bug
      update-readme
      ```

3. **Set Up the Project**
    - Ensure you have the required dependencies:
      ```sh
      mvn clean install
      ```
    - Set up your `.env` file for environment variables.
    - Run the project:
      ```sh
      mvn spring-boot:run
      ```

## 🛠 Code Guidelines

- Follow Java naming conventions.
- Format your code properly (use **Prettier/Google Java Format**).
- Keep your code **clean and readable**.
- Follow the **Single Responsibility Principle (SRP)** and write modular code.

## 📂 Branching & Commit Messages

- **Branch Naming:** Use lowercase, hyphen-separated names (`feature-add-swagger`).
- **Commits:** Write clear commit messages in present tense:
  ```
  ✅ Added Swagger for API documentation
  🔧 Fixed authentication issue
  📝 Updated README with setup steps
  ```
- **Push your branch** to remote:
  ```sh
  git push origin feature-branch-name
  ```

## 🔄 Pull Request (PR) Guidelines

1. **Open a PR to the `main` branch** (unless otherwise instructed).
2. **Follow the PR template** (if available).
3. **Clearly describe your changes** and add screenshots if applicable.
4. Request at least one review before merging.

## 📝 Issue Guidelines

- If you find a bug, **create an issue first** before fixing it.
- Provide **detailed steps to reproduce the issue** and expected vs. actual results.
- If you're working on an issue, **assign it to yourself**.

## 📢 Need Help?

- Feel free to ask questions in the discussions or issues section.
- Reach out to the maintainers if you need guidance.

🎉 **Thank you for contributing to EventSphere!** 🎉

