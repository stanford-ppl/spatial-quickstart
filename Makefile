all: install

install: 
	mkdir -p ${HOME}/bin
	make -C poly
	cp poly/emptiness ${HOME}/bin
	export PATH=${PATH}:${HOME}/bin

