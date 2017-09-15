## Robo4J-fx-lcd-example
Robo4J JavaFX LCD Demo example

Robo4J Example that simulates real behaviour of Adafruit i2c 2x16 RBG LCD Pi plate. The example
is possible to control not only over the button plate, but also over Http POST request.

default available HTTP request types

GET:<br>
http://<IP>:8025/<br>
http://<IP>:8025/controller<br>


POST:<br>
http://<IP>:8025/controller<br>
{<br> 
  "value":"down"<br>
}<br>
#####possible values: up, down, select <br>
example response: AdaruitButtonPlateEnum{button=DOWN, name='D'}

## Building from Source
The Robo4j framework uses [Gradle][] to build.
It's required to create fatJar file and run.

## Requirements
* [Java JDK 8][]
* [Robo4j.io][] :: version: alpha-0.3

## Staying in Touch
Follow [@robo4j][] or authors: [@miragemiko][] , [@hirt][]
on Twitter. In-depth articles can be found at [Robo4j.io][] or [miragemiko blog][]

## License
The Robo4j.io Framework is released under version 3.0 of the [General Public License][].

[Robo4j.io]: http://www.robo4j.io
[miragemiko blog]: http://www.miroslavkopecky.com
[General Public License]: http://www.gnu.org/licenses/gpl-3.0-standalone.html0
[@robo4j]: https://twitter.com/robo4j
[@miragemiko]: https://twitter.com/miragemiko
[@hirt]: https://twitter.com/hirt
[Gradle]: http://gradle.org
[Java JDK 8]: http://www.oracle.com/technetwork/java/javase/downloads
[Git]: http://help.github.com/set-up-git-redirect
[Robo4j documentation]: http://www.robo4j.io/p/documentation.html
