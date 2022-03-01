import { MessageModel } from './message';

describe('Message', () => {
  it('should create an instance', () => {
    expect(new MessageModel(1, 'message')).toBeTruthy();
  });
});
