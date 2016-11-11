package com.djulia.storymap

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class StoryMapController{

    @RequestMapping("/story-map")
    fun getStoryMap(): ResponseEntity<StoryMap> {
        return ResponseEntity.ok(StoryMap())
    }
}

class StoryMap {

}
