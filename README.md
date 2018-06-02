# verbose-chainsaw
## School Quotes project


**Authors:**
=================
Mitchell Vella, Cole Mollica, Gabe Mercier

Purpose
=========
The purpose of this program is to store and access quotes in a meaningful way. It allows the addition and removal of quotes/authors and allows for searching by author/quotes:tags/plaintext. This allows for exact and rough searches to find precisely what you want to.

Compiling
===========
MUST be compiled using
```sh
javac -cp ".:h2.jar:quote/h2.jar" UserInterfaec.java Quote.java
```
OR
```sh
javae -cp ".:h2.jar:quote/h2.jar" UserInterfaec.java Quote.java -r #if javae is present on the system
```

```sh
## JavEXEC
javae() {
    #take last argument passed
    declare -a argnum_new=()

    new=( "$@" )

    for i in "${!new[@]}"; do
        if [ "${new[$i]}" = "-cp" ]; then
            break
        fi
    done


    if [ $i -ne $# ] ; then
        argnum_new+=( "${new[$i]}" )
        argnum_new+=( "${new["$i" + 1]}:${PWD##*/}" )
    fi

    for i in "${!new[@]}"; do
        :
    done

    #Check if last argument is to show that
    ##it is part of a project
    if [[ "${new[$i]}" = "-r" ]]; then
        #new="${*%${!#}}"
        new=( "${@:1:$(($#-1))}" )
        for i in ${!new[@]}; do
            :
        done
    fi



    #take name of file without extension
    file=$(echo ${new[$i]} | cut -f 1 -d '.')


    #Take input file and compile it
    javac "${new[@]}"

    #execute code
    ## Based on whether it is a project
    ## or not traverse up the directory
    if [[ ${@:$#} = "-r" ]]
    then
        directory="${PWD##*/}"
	    cd ..
        if (( ${#argnum_new[@]} > 0 )); then
            java "${argnum_new[@]}" "${directory}.${file}"
        else
            java "${directory}.${file}"
        fi

        cd -
    else

        if (( ${#argnum_new[@]} > 0 )); then
            java "${argnum_new[@]}" "$file"
        else
            java "$file"
        fi
    fi

    #Delete tempfile
    rm *'.class'
}

alias javae=javae
```


H2.jar is version 1.4.197 and is the official jar

To run the project in netbeans the h2.jar has to be added to the path first, then it can be run normally.

The h2.jar can be run independently to edit the SQL database manually from the browser.
