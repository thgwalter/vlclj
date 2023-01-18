# vlclj

Example code to integrate the [VLC Media Player](https://www.videolan.org/) in a Swing application via the [vlcj](https://github.com/caprica/vlcj) library.

## Usage

First install the binaries of VLC in the resources\win32-x86-64 directory (or the equivalent for your platform).

    $ lein uberjar
    $ java -jar .\target\uberjar\vlclj-0.1.0-standalone.jar file.mp4

## License

Copyright © 2023 Thomas Walter

This program and the accompanying materials are made available under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
