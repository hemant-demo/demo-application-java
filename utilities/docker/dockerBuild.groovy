def dockerBuild(cmd){
    sh('#!/bin/sh -e\n' + cmd)
}