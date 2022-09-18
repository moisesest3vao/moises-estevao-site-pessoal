FROM node:16.16.0 as node
WORKDIR /app
COPY package.json /app
RUN npm install -g npm@8.19.2
RUN npm install --silent
COPY . .
RUN npm run build

FROM nginx:alpine
VOLUME /var/cache/nginx
COPY --from=node app/dist/my-portfolio /usr/share/nginx/html
COPY ./config/nginx.conf etc/nginx/conf.d/default.conf