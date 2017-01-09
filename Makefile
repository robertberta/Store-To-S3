all : run
build:
	echo "building"
	docker build -f deploy/Dockerfile -t ddk.mysql .
run: stopImage
	docker run -d -p 9999:3306 --name "ddk.mysql" ddk.mysql
stopImage:
	echo "stopping"
	docker stop "ddk.mysql"
	docker rm "ddk.mysql"
