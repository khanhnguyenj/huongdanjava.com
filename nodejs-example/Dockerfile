FROM node:18-alpine

RUN mkdir -p /home/node/app && chown -R node:node /home/node/app

WORKDIR /home/node/app

COPY --chown=node:node package.json ./
COPY --chown=node:node index.js ./

USER node

RUN npm install

EXPOSE 8080

CMD [ "node", "index.js" ]