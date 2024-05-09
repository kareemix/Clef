# Clef

A Java program for creating (very) simple MusicXML templates

## "Syntax"
| Command | Description |
| :---: | :---: |
| `title` | Set the title |
| `composer` | Set the composer |
| `tempo` | Set the tempo |
| `meter` | Set the time signature |
| `instrument` | Add an instrument |

## Supported Instruments

<details>
<summary>Woodwinds</summary>
  
- Piccolo
- Flute
- Oboe
- Bassoon
- Eb Clarinet
- Bb Clarinet
- Bass Clarinet
- Alto Saxophone
- Tenor Saxophone
- Baritone Saxophone

</details>

<details>
<summary>Brass</summary>

- Bb Trumpet
- F Horn
- Trombone
- Euphonium
- Tuba
  
</details>

<details>
<summary>Strings</summary>

- Double Bass

</details>

<details>
<summary>Percussion</summary>

- Timpani
- Glockenspiel
- Piano
  
</details>

## Example

This file:  

```
title "Op. 1"
composer "Kareemix"
tempo 120
meter 4:4

instrument "Alto Saxophone"
instrument "Piano"
instrument "Double Bass"
```

With this command:  

`java Main example.txt`  

Becomes:  

![image](https://kareemix.github.io/assets/clef-stuff/clef-example.png)

## TODO

- Fix second staff invisible rest for Grand Staff Instruments
- Add more instruments
