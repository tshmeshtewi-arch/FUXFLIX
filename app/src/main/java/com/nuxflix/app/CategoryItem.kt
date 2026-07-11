package com.nuxflix.app

data class CategoryItem(
    val name: String,
    val emoji: String,
    val colorRes: Int
)

object CategoryData {
    // نفس التصنيفات المستخدمة في المكتبة + شكل وألوان مطابقة للتصميم
    fun list(): List<CategoryItem> = listOf(
        CategoryItem("أكشن", "💥", R.color.cat_action),
        CategoryItem("دراما", "🎭", R.color.cat_drama),
        CategoryItem("خيال علمي", "🚀", R.color.cat_scifi),
        CategoryItem("رعب", "🎃", R.color.cat_horror),
        CategoryItem("كوميدي", "😂", R.color.cat_comedy),
        CategoryItem("رومانسية", "❤️", R.color.cat_romance),
        CategoryItem("وثائقي", "🎬", R.color.cat_documentary),
        CategoryItem("أنمي", "⛩️", R.color.cat_anime)
    )
}
