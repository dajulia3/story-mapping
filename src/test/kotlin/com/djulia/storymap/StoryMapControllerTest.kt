package com.djulia.storymap

import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.springframework.http.MediaType
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.test.web.servlet.MockMvc
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.MockMvcConfigurer
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder
import java.lang.reflect.Method

class StoryMapControllerTest {
    @get:Rule
    var restDocumentation = JUnitRestDocumentation("build/generated-snippets")

    lateinit var mockMvc: MockMvc
    @Before
    fun setup(){
        val documentationConfiguration: MockMvcConfigurer = documentationConfiguration(this.restDocumentation)
        mockMvc = MockMvcBuilders.standaloneSetup(StoryMapController())
                .apply<StandaloneMockMvcBuilder>(documentationConfiguration)
                .build()
    }
    @Test
    fun getStoryMap() {
        this.mockMvc.perform(get("/story-map").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("story-map"))
    }
}