class TenthLine {
    // shell
    // The n option with the print command is used to only print lines explicitly indicated by the command.
    // Given a text file file.txt, print just the 10th line of the file.
    cat file.txt | sed -n '10p'

    // awk has a built in variable NR that keeps track of file/stream row numbers.
    cat file.txt | awk 'NR==10'     # > 73%
    cat file.txt | awk 'NR==10{print}'  # > 100%
    cat file.txt | awk '{if(NR==10) print}'  # >73%
}