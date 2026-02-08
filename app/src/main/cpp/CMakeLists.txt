cmake_minimum_required(VERSION 3.22.1)

project("simplejni")

add_library(
        simplejni
        SHARED
        native-lib.cpp)

find_library(
        log-lib
        log)

target_link_libraries(
        simplejni
        ${log-lib})
