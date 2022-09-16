import { Component, OnInit } from '@angular/core';
import { TranslationLoaderService } from '../service/translation-loader.service';
import { locale as english } from '../shared/i18n/en';
import { locale as portuguese } from '../shared/i18n/pt';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  // skills:any={
  //   technologies:[{name:"Java, Spring Boot",percent:90,remark:'excellent', image:'/src/assets/images/api-calls-async.png'},{name:"JavaScript, TypeScript, Angular",percent:70,remark:'very-good'},{name:"AWS Cloud",percent:70,remark:'very-good'}],
  //   tools:[{name:"Git, GitHub, Bitbucket",percent:90,remark:'excellent'},{name:"MySql, MariaDB",percent:70,remark:'very-good'},{name:"Linux, Windows",percent:70,remark:'very-good'}],
  //   methodologies:[{name:"Clean-Code, TDD",percent:70,remark:'very-good'},{name:"Scrum",percent:70,remark:'very-good'},{name:"Cybersecurity",percent:70,remark:'very-good'}]
  // };

  constructor(private _translationLoaderService: TranslationLoaderService) {
    this._translationLoaderService.loadTranslations(english, portuguese);
  }

  ngOnInit(): void {
  }

}




