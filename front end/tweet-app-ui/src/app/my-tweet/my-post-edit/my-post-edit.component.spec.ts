import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPostEditComponent } from './my-post-edit.component';

describe('MyPostEditComponent', () => {
  let component: MyPostEditComponent;
  let fixture: ComponentFixture<MyPostEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyPostEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPostEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
