package name.sargon

import name.sargon.Bitboards.FILE_E
import name.sargon.Bitboards.RANK_4

fun main() {
    val bb = FILE_E.or(RANK_4)

    println(bb)

    val bbi = BitIterator(bb)
    while (bbi.hasNext()) {
        println(bbi.next().toName())
    }
}
