# ScalAwk

Scala DSL to easily compose [awk](http://www.gnu.org/software/gawk/manual/gawk.html) programs.
Its underlying goal is to serve as a simple and concise example of how to build DSLs upong Scala.

## Features

It targets a subset of awk on which you can build commands with:

- Customized separators.
- Actions executed before iterating over the input lines.
- Actions for each line.
- Actions after the input has been exhausted.

These actions can be composed of one or several:

- Variable assignments.
- Arithmetic operations: +, -, *, /
- String concatenations.
- Prints to standard output.

## Examples

### Count lines:

    lines provided('s := 0) computing ('s := 's + 1) finallyDo (present('s))
    > awk 'BEGIN{s = 0; }{s = s + 1; }END{print s; }'

### Concatenation with custom split element

    lines splitBy ";" arePresentedAs ('c1, 'c2)
    > awk -F ';' '{print $1 $2; }'

or:

    lines splitBy ";" computing ('concatenated := 'c1 ++ 'c2) arePresentedAs ('concatenated)
    > awk -F ';' '{concatenated = $1  $2; print concatenated; }'

### Regular expressions as token separators

    lines splitBy "_+".r arePresentedAs ('c1, " ", 'c2, "hello", 1, 'x)
    > awk -F '_+' '{print $1 " " $2 "hello" 1 x; }'

### Other examples

    lines splitBy "_+".r arePresentedAs ('c1, " ", 'c2, "hello", 1, 'x)
    > awk -F '_+' '{print $1 " " $2 "hello" 1 x; }'
    
    lines computing ('x := 4, 's := 2, 'res := 'x * ('s + 1)) arePresentedAs ('res)
    > awk '{x = 4; s = 2; res = x * (s + 1); print res; }'

