# syntax=docker/dockerfile:1

ARG NODE_VERSION=14.21.3
FROM node:${NODE_VERSION}-alpine

# Use production node environment by default.
ENV NODE_ENV production

WORKDIR /usr/src/app

# Clean npm cache
RUN npm cache clean --force

# Install dependencies separately to leverage Docker's caching
COPY package.json package-lock.json ./
RUN npm install --no-optional

# Run the application as a non-root user.
USER node

# Copy the rest of the source files into the image.
COPY . .

# Expose the port that the application listens on.
EXPOSE 4200

# Run the application.
CMD ["npm", "start"]
