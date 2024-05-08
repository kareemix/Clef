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
- Bb Trumpet
- F Horn
- Trombone
- Euphonium
- Tuba
- Double Bass
- Timpani
- Glockenspiel
- Piano

## Example
```
title "Op. 1"
composer "Kareemix"
tempo 120
meter 4:4

instrument "Alto Saxophone"
instrument "Piano"
instrument "Double Bass"
```
