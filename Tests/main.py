#Imports, for the window and music
import tkinter as tk
from tkinter import ttk
from tkinter import filedialog as fd
from tkinter.messagebox import showinfo
import muspy

#Create window
window = tk.Tk()
window.title('Music Project')
window.resizable(False, False)
window.geometry('300x200')
window.grid()



#Function to convert midi to json
def midi_to_json():

    filetypes = (
        ('Midi Files', '*.mid'),
        ('All files', '*.*')
    )

    filename = fd.askopenfilename(
        title='Open a midi file',
        initialdir='/',
        filetypes=filetypes)
    
    music = muspy.read_midi(filename)
    music.save(filename + ".json")
    print("mid_to_json run")
    

#Function to convert mscz to json
def mscz_to_json():

    filetypes = (
        ('Musescore Files', '*.mscz'),
        ('All files', '*.*')
    )

    filename = fd.askopenfilename(
        title='Open a mscz file',
        initialdir='/',
        filetypes=filetypes)
    
    music = muspy.read_musescore(filename)
    music.save(filename + ".json")
    print("mscz to json run")
    

#Function to convert json to midi
def json_to_midi():

    filetypes = (
        ('JSON Files', '*.json'),
        ('All files', '*.*')
    )

    filename = fd.askopenfilename(
        title='Open a JSON file',
        initialdir='/',
        filetypes=filetypes)
    
    music = muspy.load(filename)
    music.write(filename + ".mid", "midi")
    print("json_to_mid run")
    

#Function to convert json to mxl
def json_to_mxl():

    filetypes = (
        ('JSON Files', '*.json*'),
        ('All files', '*.*')
    )

    filename = fd.askopenfilename(
        title='Open a JSON file',
        initialdir='/',
        filetypes=filetypes)
    
    music = muspy.load(filename)
    music.write(filename + ".mxl", "musicxml")
    print("json_to_mxl run")


#Button to select a midi file to convert to json
midi_to_json_button = ttk.Button(
    window,
    text = ".mid to .json",
    command = midi_to_json
)

#Button to select a mscz file to convert to json
mscz_to_json_button = ttk.Button(
    window,
    text = ".mscz to .json",
    command = mscz_to_json
)

#Button to select a json file to convert to midi
json_to_midi_button = ttk.Button(
    window,
    text = ".json to .mid",
    command = json_to_midi
)

#Button to select a json file to convert to mscz
json_to_mxl_button = ttk.Button(
    window,
    text = ".json to .mxl",
    command = json_to_mxl
)


midi_to_json_button.pack(expand=True)
json_to_midi_button.pack(expand=True)
mscz_to_json_button.pack(expand=True)
json_to_mxl_button.pack(expand=True)

window.mainloop()
