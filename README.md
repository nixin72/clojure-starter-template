# Set up IDE

I recommend you read this whole thing! It's not very long, and it will save you
time and frustration! Clojure is a very simple and fun language, and it's
unfortunate that the requirements for submission of this project actively encourage
that you do things wrong.

1. Install the required tools.

- Clojure itself: https://clojure.org/guides/install_clojure
- Visual Studio Code: https://code.visualstudio.com/Download
- The Calva vscode extension: https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva

2. Clone/download this template. 
If you have git, run
```
https://github.com/nixin72/clojure-starter-template.git
```
Otherwise, in the GitHub UI, hit the `<> Code` button, and at the bottom of the popup, 
click "Download Zip". Go to your downloads folder, unzip this, and put it wherever.

3. Open this project in vscode

4. Open the `app.clj` file

5. Start an interactive window for development
Hit `ctrl+shift+p` (or `cmd+shift+p` on mac) and type in "Calva: Start a project REPL and connect".

You'll see a popup asking you to "select a project type". This should be `deps.edn`.

It'll then ask you if there's any aliases you want to launch with.
This doesn't really matter for you, so just click OK.

You should now see a window open on the right of vscode. This will be used for viewing the
output of compiling and running your code.

6. Compile your project
In the `app.clj` file, run the command "Calva: Load/Evaluate Current File and its Requires/Dependencies"
In the window on the right, you'll see

```clj
clj:user:>
; Evaluating file: app.clj
This should probably do something with 10 and 20
This should do something too
clj:app:>
```

If you see this, you're good to go.

7. To write your code, you'll want to use that "Calva: Load/Evaluate Current File ..."
command or "Calva: Evaluate Top Level Form". DO NOT run the Clojure command in your
terminal/command line to run your code every time. You'll find this is very slow. It
took my computer 3 seconds to run this template. Instead, the way Clojure is developed is
using a REPL (Read Eval Print Loop)[1]. You've already started the REPL in step 5 and loaded
everything into it in 6. The typical workflow is to continue evaluating things with
"Calva: Evaluate Top Level Form" as you write them.

Try entering this into `app.clj`

```clj
(let [x 10, y 20]
    (println "Coding in a REPL")
    (+ x y))
```

And now run "Calva: Evaluate Top Level Form". In the window on the right, you'll see
the "Coding in a REPL" printed, with "30" right below it. You'll also see the `30` printed
out right in-line in your editor.

Now try entering

```clj
(do
  (defn testing-something [x y]
    (+ x y))

  (println "Test cases")
  (println (testing-something 10 20))
  (println (testing-something 25 30))
  (println (testing-something 100 200))

 )
```

And running the evaluate command again. You'll see all the test cases
printed out in the REPL window. This is a great way to test changes very quickly,
wrap your function in a `do` and then call it a bunch and print out the results.

Never needing to leave your text editor window to run code is very nice, and it lets
you get things done very quickly instead of swapping between windows and re-running
Clojure every time.

8. To submit your project of course, your TAs will not be using a REPL most likely,
they'll be running things in a terminal. You can try running your code in a terminal
using `clj -M:run` - this will use the `-main` function in `app.clj` as an entry-point
and run all your code. If this works, then however the TAs chose to run your code should
work too with their manual classpath setting stuff.

---

[1] If you're interested, the reason this is so slow is because Clojure runs on the JVM.
While the JVM is very fast once running, starting things up takes a little bit of time
because the JVM process needs to load every class into memory before it can run anything.
In Clojure, every function compiles to a JVM class, and the Clojure standard library is
over 600 functions (plus internal stuff of course), which means the JVM is loading _a lot_
of classes every time you run that Clojure command. As such, Clojure developers never
write code this way. We start a REPL that runs a JVM instance, and we use commands like
the ones I mentioned above to load code into that JVM and run it. This way we can develop
much faster than if we re-ran our code every time. In very large projects in any language,
waiting for things to compile is often a huge problem. Large Java, Scala, C++, C#, etc code
bases can sometimes take upwards of an hour to compile, and that's a crazy long time to wait
to see your changes. In Clojure, no matter how big your project is, you load it into a REPL
(which might initially take a bit of time), and then re-evaluate things on the fly and you
can see your changes instantly, no matter how big your codebase is.
