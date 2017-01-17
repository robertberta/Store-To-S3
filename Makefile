all : start
build:
	docker build -f deploy/Dockerfile -t ddk.mysql .
	docker run -d -p 9999:3306 --name "ddk.mysql" ddk.mysql
start: stopImage
	docker start ddk.mysql
stop : stopImage
stopImage :
	docker stop "ddk.mysql"
	#docker rm "ddk.mysql"
