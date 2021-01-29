import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportacionArchivoComponent } from './importacion-archivo.component';

describe('ImportacionArchivoComponent', () => {
  let component: ImportacionArchivoComponent;
  let fixture: ComponentFixture<ImportacionArchivoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImportacionArchivoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportacionArchivoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
