package name.sargon

@Suppress("unused")
object Bitboards {
    val FILE_A = Bitboard(0x0101010101010101UL)
    val FILE_B = Bitboard(0x0202020202020202UL)
    val FILE_C = Bitboard(0x0404040404040404UL)
    val FILE_D = Bitboard(0x0808080808080808UL)
    val FILE_E = Bitboard(0x1010101010101010UL)
    val FILE_F = Bitboard(0x2020202020202020UL)
    val FILE_G = Bitboard(0x4040404040404040UL)
    val FILE_H = Bitboard(0x8080808080808080UL)

    val files = arrayOf(FILE_A, FILE_B, FILE_C, FILE_D, FILE_E, FILE_F, FILE_G, FILE_H)

    val RANK_1 = Bitboard(0x00000000000000FFUL)
    val RANK_2 = Bitboard(0x000000000000FF00UL)
    val RANK_3 = Bitboard(0x0000000000FF0000UL)
    val RANK_4 = Bitboard(0x00000000FF000000UL)
    val RANK_5 = Bitboard(0x000000FF00000000UL)
    val RANK_6 = Bitboard(0x0000FF0000000000UL)
    val RANK_7 = Bitboard(0x00FF000000000000UL)
    val RANK_8 = Bitboard(0xFF00000000000000UL)

    val ranks = arrayOf(RANK_1, RANK_2, RANK_3, RANK_4, RANK_5, RANK_6, RANK_7, RANK_8)
}

@JvmInline
value class Bitboard(val value: ULong = 0UL) : Iterable<Int> {

    companion object {
        fun empty() = Bitboard(0UL)
    }

    fun isEmpty(): Boolean = value == 0UL
    fun countOnes(): Int = value.countOneBits()
    infix fun and(other: Bitboard): Bitboard = Bitboard(value and other.value)
    infix fun or(other: Bitboard): Bitboard = Bitboard(value or other.value)

    fun get(square: Square): Boolean = (value and 1UL.shl(square)) != 0UL
    fun set(square: Square): Bitboard = Bitboard(value or 1UL.shl(square))
    fun cleared(square: Square): Bitboard = Bitboard(value and 1UL.shl(square).inv())

    fun nextOne(): Int {
        val next = value.countTrailingZeroBits()
        assert(next in 0..63)

        return next
    }

    override fun iterator(): Iterator<Int> {
        return BitIterator(this)
    }

    override fun toString(): String {
        val str = StringBuilder()

        for (y in 7.downTo(0)) {
            str.append(y + 1)

            for (x in 0..7) {
                val square = x + y * 8
                str.append(" ")
                str.append(if (this.get(square)) "*" else ".")
            }

            str.append(" " + (y + 1) + "\n")
        }

        str.append("  a b c d e f g h\n")

        return str.toString()
    }
}

class BitIterator(private var bitboard: Bitboard) : Iterator<Int> {

    override fun hasNext(): Boolean = !bitboard.isEmpty()

    override fun next(): Int {
        val next = bitboard.nextOne()
        bitboard = bitboard.cleared(next)

        return next
    }

}

class SubsetIterator(private val bitboard: Bitboard) : Iterator<IndexedValue<Bitboard>> {

    private var idx: Int = 0
    private var subset: ULong = 0UL

    override fun hasNext(): Boolean = (idx == 0) or (subset != 0UL)

    override fun next(): IndexedValue<Bitboard> {
        subset = (subset - bitboard.value) and bitboard.value
        return IndexedValue(idx++, Bitboard(subset))
    }

}
