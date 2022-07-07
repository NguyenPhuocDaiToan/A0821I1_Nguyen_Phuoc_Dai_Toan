import { Injectable } from '@angular/core';
import {Word} from "../model/word";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words: Word[] = [
    {word: 'Hello', mean: 'Xin chào'},
    {word: 'Goodbye', mean: 'Tạm biệt'},
    {word: 'Sorry', mean: 'Xin lỗi'},
  ];
  constructor() { }

  getWord(word: string) {
    return this.words.find(w => w.word == word);
  }

  getAll() {
    return this.words;
  }
}
