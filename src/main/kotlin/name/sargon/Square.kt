package name.sargon

typealias Square = Int

fun Square.toFile() = this and 7
fun Square.toRank() = this shr 3
fun Square.toName(): String {
    val file = 'A' + toFile()
    val rank = '1' + toRank()
    return "${file}${rank}"
}

fun square(file: Int, rank: Int): Square = file + rank * 8


@Suppress("unused")
class NamedSquare {
    companion object {
        const val A1: Square = (0 * 8 + 0)
        const val A2: Square = (1 * 8 + 0)
        const val A3: Square = (2 * 8 + 0)
        const val A4: Square = (3 * 8 + 0)
        const val A5: Square = (4 * 8 + 0)
        const val A6: Square = (5 * 8 + 0)
        const val A7: Square = (6 * 8 + 0)
        const val A8: Square = (7 * 8 + 0)

        const val B1: Square = (0 * 8 + 1)
        const val B2: Square = (1 * 8 + 1)
        const val B3: Square = (2 * 8 + 1)
        const val B4: Square = (3 * 8 + 1)
        const val B5: Square = (4 * 8 + 1)
        const val B6: Square = (5 * 8 + 1)
        const val B7: Square = (6 * 8 + 1)
        const val B8: Square = (7 * 8 + 1)

        const val C1: Square = (0 * 8 + 2)
        const val C2: Square = (1 * 8 + 2)
        const val C3: Square = (2 * 8 + 2)
        const val C4: Square = (3 * 8 + 2)
        const val C5: Square = (4 * 8 + 2)
        const val C6: Square = (5 * 8 + 2)
        const val C7: Square = (6 * 8 + 2)
        const val C8: Square = (7 * 8 + 2)

        const val D1: Square = (0 * 8 + 3)
        const val D2: Square = (1 * 8 + 3)
        const val D3: Square = (2 * 8 + 3)
        const val D4: Square = (3 * 8 + 3)
        const val D5: Square = (4 * 8 + 3)
        const val D6: Square = (5 * 8 + 3)
        const val D7: Square = (6 * 8 + 3)
        const val D8: Square = (7 * 8 + 3)

        const val E1: Square = (0 * 8 + 4)
        const val E2: Square = (1 * 8 + 4)
        const val E3: Square = (2 * 8 + 4)
        const val E4: Square = (3 * 8 + 4)
        const val E5: Square = (4 * 8 + 4)
        const val E6: Square = (5 * 8 + 4)
        const val E7: Square = (6 * 8 + 4)
        const val E8: Square = (7 * 8 + 4)

        const val F1: Square = (0 * 8 + 5)
        const val F2: Square = (1 * 8 + 5)
        const val F3: Square = (2 * 8 + 5)
        const val F4: Square = (3 * 8 + 5)
        const val F5: Square = (4 * 8 + 5)
        const val F6: Square = (5 * 8 + 5)
        const val F7: Square = (6 * 8 + 5)
        const val F8: Square = (7 * 8 + 5)

        const val G1: Square = (0 * 8 + 6)
        const val G2: Square = (1 * 8 + 6)
        const val G3: Square = (2 * 8 + 6)
        const val G4: Square = (3 * 8 + 6)
        const val G5: Square = (4 * 8 + 6)
        const val G6: Square = (5 * 8 + 6)
        const val G7: Square = (6 * 8 + 6)
        const val G8: Square = (7 * 8 + 6)

        const val H1: Square = (0 * 8 + 7)
        const val H2: Square = (1 * 8 + 7)
        const val H3: Square = (2 * 8 + 7)
        const val H4: Square = (3 * 8 + 7)
        const val H5: Square = (4 * 8 + 7)
        const val H6: Square = (5 * 8 + 7)
        const val H7: Square = (6 * 8 + 7)
        const val H8: Square = (7 * 8 + 7)
    }
}
