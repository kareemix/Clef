import sys
import muspy

if(len(sys.argv) < 1 or len(sys.argv) > 1):
    print("Invalid Input")
    sys.exit(1)

input_file = sys.argv[1]

music = muspy.load(input_file)
music.write(input_file + ".mid", "midi")
