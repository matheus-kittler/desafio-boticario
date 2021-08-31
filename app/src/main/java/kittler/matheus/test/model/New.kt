package kittler.matheus.test.model

data class New(
    val recovers: List<Recover>
) {
    val hasRecovers = recovers.isNotEmpty()
}