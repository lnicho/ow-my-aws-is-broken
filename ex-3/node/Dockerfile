FROM node:alpine
WORKDIR /
COPY package*.json ./
COPY . .
RUN npm install
EXPOSE 3000
ENTRYPOINT ["node", "App.js"]
