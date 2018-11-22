all: install

install: 
	sbt compile

clean:
	rm ${HOME}/bin/emptiness

