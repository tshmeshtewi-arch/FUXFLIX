package com.nuxflix.app

import android.graphics.Color

object MovieRepository {

    private val moviesList = listOf(
        // ========== 🔥 رومانسية ==========
        Movie(
            id = 1,
            title = "The Notebook",
            description = "قصة حب خالدة بين شاب وفتاة من طبقتين مختلفتين خلال الحرب العالمية الثانية. فيلم درامي رومانسي يأخذك في رحلة مشاعر لا تُنسى.",
            year = "2004",
            duration = "2h 3m",
            rating = "⭐ 7.8",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1518895949257-7621c3c786d7?w=400",
            posterColor = Color.parseColor("#8B0000"),
            category = "رومانسية",
            isFeatured = true
        ),
        Movie(
            id = 2,
            title = "Titanic",
            description = "قصة حب أسطورية على متن سفينة تايتانيك المنكوبة. جاك روز يتحديان المستحيل.",
            year = "1997",
            duration = "3h 14m",
            rating = "⭐ 7.9",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1536440136628-849c177e76a1?w=400",
            posterColor = Color.parseColor("#1B3B6F"),
            category = "رومانسية",
            isFeatured = true
        ),
        Movie(
            id = 3,
            title = "La La Land",
            description = "موسيقي رومانسي عن ممثلة وعازف جاز يحاولان تحقيق أحلامهم في لوس أنجلوس.",
            year = "2016",
            duration = "2h 8m",
            rating = "⭐ 8.0",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1489599849927-2ee91cede3ba?w=400",
            posterColor = Color.parseColor("#4A0E4E"),
            category = "رومانسية"
        ),

        // ========== 💥 أكشن ==========
        Movie(
            id = 4,
            title = "John Wick 4",
            description = "القاتل الأسطوري جون ويك يعود في مغامرة جديدة مليئة بالإثارة والمشاهد القتالية المذهلة.",
            year = "2023",
            duration = "2h 49m",
            rating = "⭐ 7.6",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1537420327992-d6e192287183?w=400",
            posterColor = Color.parseColor("#1A1A1A"),
            category = "أكشن",
            isFeatured = true
        ),
        Movie(
            id = 5,
            title = "Mad Max: Fury Road",
            description = "في عالم ما بعد النهاية، يخوض ماكس وفوريوس معركة يائسة عبر الصحراء للنجاة بحريتهم.",
            year = "2015",
            duration = "2h 0m",
            rating = "⭐ 8.1",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1552072092-7f9b8d63efcb?w=400",
            posterColor = Color.parseColor("#B8860B"),
            category = "أكشن",
            isFeatured = true
        ),
        Movie(
            id = 6,
            title = "The Dark Knight",
            description = "باتمان يواجه أعتى أعدائه الجوكر في معركة العقل والجنون، فيلم أكشن وإثارة لا يُفوّت.",
            year = "2008",
            duration = "2h 32m",
            rating = "⭐ 9.0",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1509347528160-9a9e33742cdb?w=400",
            posterColor = Color.parseColor("#0D0D0D"),
            category = "أكشن"
        ),

        // ========== 😢 دراما ==========
        Movie(
            id = 7,
            title = "The Shawshank Redemption",
            description = "قصة آندي دوفرين المسجون ظلماً ورحلته الطويلة نحو الحرية والأمل في سجن شوشانك.",
            year = "1994",
            duration = "2h 22m",
            rating = "⭐ 9.3",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1440404653325-ab127d49abc1?w=400",
            posterColor = Color.parseColor("#2C3E50"),
            category = "دراما",
            isFeatured = true
        ),
        Movie(
            id = 8,
            title = "Forrest Gump",
            description = "قصة فورست غامب البسيط الذي عاش أعظم الأحداث التاريخية وألهم الملايين بحبه للحياة.",
            year = "1994",
            duration = "2h 22m",
            rating = "⭐ 8.8",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1485846234645-a62644f84728?w=400",
            posterColor = Color.parseColor("#2E7D32"),
            category = "دراما",
            isFeatured = true
        ),

        // ========== 😂 كوميدي ==========
        Movie(
            id = 9,
            title = "The Hangover",
            description = "ثلاثة أصدقاء يستيقظون بعد حفل توديع عزوبية لا يتذكرون شيئاً ويبحثون عن العريس المفقود.",
            year = "2009",
            duration = "1h 40m",
            rating = "⭐ 7.7",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1527224857830-43a7acc85260?w=400",
            posterColor = Color.parseColor("#F57C00"),
            category = "كوميدي",
            isFeatured = true
        ),
        Movie(
            id = 10,
            title = "Superbad",
            description = "قصة طالبين ثانوية عامين في ليلة واحدة يحاولان فيها شراء الكحول لحفلة ويواجهان مغامرات جنونية.",
            year = "2007",
            duration = "1h 53m",
            rating = "⭐ 7.6",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1514525253161-7a46d19cd819?w=400",
            posterColor = Color.parseColor("#1565C0"),
            category = "كوميدي"
        ),

        // ========== 👻 رعب ==========
        Movie(
            id = 11,
            title = "The Conjuring",
            description = "عائلة تتعرض لأحداث خارقة في منزلهم الجديد، فيلجأون إلى محققي الظواهر الخاربة وارن.",
            year = "2013",
            duration = "1h 52m",
            rating = "⭐ 7.5",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1509248961158-c54f69348069?w=400",
            posterColor = Color.parseColor("#1A1A1A"),
            category = "رعب",
            isFeatured = true
        ),
        Movie(
            id = 12,
            title = "Hereditary",
            description = "بعد وفاة جدتهم الغامضة، عائلة تعاني من أحداث مرعبة تكشف أسراراً مظلمة في تاريخهم.",
            year = "2018",
            duration = "2h 7m",
            rating = "⭐ 7.3",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1478720568477-152d9b164e26?w=400",
            posterColor = Color.parseColor("#2E0A0A"),
            category = "رعب"
        ),

        // ========== 🤖 خيال علمي ==========
        Movie(
            id = 13,
            title = "Interstellar",
            description = "رحلة عبر الثقوب الدودية إلى مجرات بعيدة لإنقاذ البشرية من الانقراض. تحفة خيال علمي.",
            year = "2014",
            duration = "2h 49m",
            rating = "⭐ 8.7",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?w=400",
            posterColor = Color.parseColor("#0D1B2A"),
            category = "خيال علمي",
            isFeatured = true
        ),
        Movie(
            id = 14,
            title = "The Matrix",
            description = "نيو يكتشف أن العالم الذي يعيش فيه مجرد محاكاة افتراضية ويصبح المنقذ الوحيد للبشرية.",
            year = "1999",
            duration = "2h 16m",
            rating = "⭐ 8.7",
            videoUrls = mapOf(
                "360p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "480p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "720p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "1080p" to "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
            ),
            posterUrl = "https://images.unsplash.com/photo-1536240478700-b869070f9279?w=400",
            posterColor = Color.parseColor("#003300"),
            category = "خيال علمي",
            isFeatured = true
        )
    )

    fun getAllMovies(): List<Movie> = moviesList

    fun getFeaturedMovies(): List<Movie> = moviesList.filter { it.isFeatured }

    fun getMovieById(id: Int): Movie? = moviesList.find { it.id == id }

    fun getCategories(): List<String> = moviesList.map { it.category }.distinct().sorted()

    fun getMoviesByCategory(category: String): List<Movie> = moviesList.filter { it.category == category }

    fun searchMovies(query: String): List<Movie> {
        if (query.isBlank()) return moviesList
        return moviesList.filter {
            it.title.contains(query, ignoreCase = true) ||
            it.description.contains(query, ignoreCase = true) ||
            it.category.contains(query, ignoreCase = true)
        }
    }
}