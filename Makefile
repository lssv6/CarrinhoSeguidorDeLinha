FILENAME=MyBlindCar.ino

.PHONY: compile_and_upload
compile_and_upload:
	arduino-cli compile $(FILENAME) && \
	arduino-cli upload $(FILENAME);

.PHONY: monitor
monitor:
	./monitor/gradlew run -p ./monitor/ --console=plain
