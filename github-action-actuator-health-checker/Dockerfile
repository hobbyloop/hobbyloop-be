FROM 1.16.15-alpine3.14

WORKDIR /app

COPY ./ ./

RUN go build -o /bin/app main.go

ENTRYPOINT ["app"]