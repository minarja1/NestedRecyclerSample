package com.example.nestedrecyclersample.data

import com.example.nestedrecyclersample.data.domain.Animal
import com.example.nestedrecyclersample.data.domain.AnimalSection

object DataSource {

    private val cats = listOf(
        Animal("Cat1", "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png"),
        Animal(
            "Cat2",
            "https://i.guim.co.uk/img/media/26392d05302e02f7bf4eb143bb84c8097d09144b/446_167_3683_2210/master/3683.jpg?width=445&quality=45&auto=format&fit=max&dpr=2&s=42132184edabf489cb379824f3da6f61"
        ),
        Animal(
            "Cat3",
            "https://static.scientificamerican.com/sciam/cache/file/32665E6F-8D90-4567-9769D59E11DB7F26_source.jpg?w=590&h=800&7E4B4CAD-CAE1-4726-93D6A160C2B068B2"
        ),
        Animal(
            "Cat4",
            "https://images.theconversation.com/files/350865/original/file-20200803-24-50u91u.jpg?ixlib=rb-1.1.0&rect=37%2C29%2C4955%2C3293&q=45&auto=format&w=926&fit=clip"
        ),
    )

    private val capybaras = listOf(
        Animal(
            "Capybara1",
            "https://i.pinimg.com/originals/3e/bf/fe/3ebffe6c1725f083ca6f3d5a1cb17bbb.jpg"
        ),
        Animal(
            "Capybara2",
            "https://i1.wp.com/www.thesun.co.uk/wp-content/uploads/2019/08/NINTCHDBPICT000515260574-e1566509448716.jpg?crop=0px%2C142px%2C611px%2C407px&resize=1200%2C800&ssl=1"
        ),
        Animal(
            "Capybara3",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbxCLHH-Y03iCxX75DrA7mJ2SNd7752PgMGg&usqp=CAU"
        ),
        Animal(
            "Capybara4",
            "https://i1.wp.com/blog.workman.com/wp-content/uploads/2015/02/Baby-Capybara-and-mama.jpg"
        ),
    )

    private val pandas = listOf(
        Animal(
            "Panda1",
            "https://i.pinimg.com/originals/e0/3d/5b/e03d5b812b2734826f76960eca5b5541.jpg"
        ),
        Animal(
            "Panda2",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5eApPfjVWxjb8wFr-18wIay0mzty9njSRqA&usqp=CAU"
        ),
        Animal(
            "Panda3",
            "https://static01.nyt.com/images/2020/08/16/reader-center/14-panda-baby/14-panda-baby-facebookJumbo.jpg"
        ),
        Animal(
            "Panda4",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsER4Lqp3KpVkbVBEfXChpOGGcPUY3BHDo3Q&usqp=CAU"
        ),
    )

    private val pikas = listOf(
        Animal("Pika1", "https://i.ytimg.com/vi/eQ0XSifoNOI/maxresdefault.jpg"),
        Animal(
            "Pika2",
            "https://static.scientificamerican.com/blogs/cache/file/E2B7050D-8D18-43AE-8CC12F1BF07119BD_source.jpg?w=590&h=800&45B1350F-D680-4253-B4FCEC542384D084"
        ),
        Animal(
            "Pika3",
            "https://www.treehugger.com/thmb/WGb-3uM3NvLvG3uiAizSa61hAIo=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration__mnn__images__2017__08__american-pika-grass-2993b02a0caf4249a0a6124929b6b53c.jpg"
        ),
        Animal(
            "Pika4",
            "https://s.abcnews.com/images/International/ht_ili_pika_cute_chinese_mammal_jc_150325_4x3t_608.jpg"
        ),
    )

    private val titles = listOf("Cats", "Pandas", "Capybaras", "Pikas")

    private val titlesToAnimals: HashMap<String, List<Animal>> = hashMapOf(
        titles[0] to cats,
        titles[1] to pandas,
        titles[2] to capybaras,
        titles[3] to pikas,
    )


    /**
     * Creates and populates given number of sections with given number of items.
     *
     * [numberOfSections] the size of returned list of Sections
     * [itemsPerSection] the number of items inside each section
     */
    fun createSections(numberOfSections: Int, itemsPerSection: Int): List<AnimalSection> {
        val sections = mutableListOf<AnimalSection>()

        for (i in 0 until numberOfSections) {
            val animals = mutableListOf<Animal>()
            val title = titles.random()
            val section = AnimalSection(title = title, animals = animals)
            for (j in 0 until itemsPerSection) {
                animals.add(titlesToAnimals[title]!!.random())
            }
            sections.add(section)
        }

        return sections
    }

}