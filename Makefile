.PHONY: all build deploy clean
build: dist/index.js
all: build
clean:
	rm -rf dist
dist/index.js: index.scala
	scala-cli package -f --js --js-module-kind es -o dist index.scala
dist/package.json: # Since we cannot configure linker config to set extension as .mjs, we manually declare the module is ES module
	mkdir -p dist
	echo '{ "main": "index.js", "type": "module" }' > dist/package.json
deploy: dist/index.js dist/package.json
	lambroll --profile=windymelt deploy --src=dist