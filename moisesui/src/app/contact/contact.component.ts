import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MensagemService } from '../service/mensagem.service';
import { TranslationLoaderService } from '../service/translation-loader.service';
import { locale as english } from '../shared/i18n/en';
import { locale as portuguese } from '../shared/i18n/pt';
type Mensagem = {
  email:string,
  assunto:string,
  nome:string,
  mensagem:string
}
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  formMensagem!:FormGroup;
  mensagem!:Mensagem;
  enviouFormulario: boolean = false;
  captcha:string | null;

  constructor(
    private _translationLoaderService: TranslationLoaderService,
    private formBuilder: FormBuilder,
    private service: MensagemService
    ){
    this._translationLoaderService.loadTranslations(english, portuguese);
    this.captcha = null;
  }

  ngOnInit(): void {
    this.formMensagem = this.formBuilder.group({
      mensagem:["", Validators.required],
      assunto: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      nome: ["", Validators.required],
    });
  }

  enviaMensagem(){
    var response = null;
    this.mensagem = this.formMensagem.value;
    this.service.salvaMensagem(this.mensagem).subscribe(data => {
      response=data;
      console.log(response);
    });
    this.enviouFormulario = true;
  }

  resolved(captchaResponse: string){
    this.captcha = captchaResponse;
    console.log('resolved captcha with response: '+this.captcha);

  }
}
