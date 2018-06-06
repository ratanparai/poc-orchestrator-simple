FROM nginx:alpine
EXPOSE 80 443
COPY dist/frontend /usr/share/nginx/html
ENTRYPOINT [ "nginx", "-g", "daemon off;" ]