import { Component, OnInit } from '@angular/core';
import * as awesom from '@fortawesome/free-solid-svg-icons';
import { TranslationLoaderService } from '../service/translation-loader.service';
import { locale as english } from '../shared/i18n/en';
import { locale as portuguese } from '../shared/i18n/pt';
import { experiencesPt} from '../api/experiencesPt';
import { experiencesEn} from '../api/experiencesEn';
import { TranslateService } from '@ngx-translate/core';
@Component({
  selector: 'app-curriculum-vitae',
  templateUrl: './curriculum-vitae.component.html',
  styleUrls: ['./curriculum-vitae.component.css']

})
export class CurriculumVitaeComponent implements OnInit {
  experiences:any=experiencesEn;
  planeIcon: any ;
  gameIcon:any;
  volleyBallIcon:any;

  constructor(private _translationLoaderService: TranslationLoaderService,private _translateService: TranslateService) {
    this._translationLoaderService.loadTranslations(english, portuguese);
    this._translateService.onLangChange.subscribe(()=>{
      if(this._translateService.currentLang=="en"){
        this.experiences=experiencesEn;
      }
      else{
        this.experiences=experiencesPt;
      }
    });
  }

  ngOnInit(): void {
    this.planeIcon=awesom.faPlane;
    this.gameIcon=awesom.faGamepad;
    this.volleyBallIcon=awesom.faVolleyballBall;
  }
  
  detailOnClick(experience:any) {
    experience.detailIsDisplayed=!experience.detailIsDisplayed;
  }
 

}
