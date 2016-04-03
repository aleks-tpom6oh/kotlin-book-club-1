package com.quizup.kotlinbookclub

/**
 * @author alexey@plainvanillagames.com
 *
 * 02/04/16.
 */

interface Command<T> {
    fun execute(): T
}