FROM mongo:latest


ENV MONGO_INITDB_DATABASE DB_CART

COPY ./*.sh /docker-entrypoint-initdb.d/
COPY docker-health /

EXPOSE 3306 8081

